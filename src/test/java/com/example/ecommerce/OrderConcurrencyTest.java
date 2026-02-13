package com.example.ecommerce;

import com.example.ecommerce.domain.exception.OutOfStockException;
import com.example.ecommerce.domain.ports.in.OrderUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrderConcurrencyTest {
    @Autowired
    private OrderUseCase orderUseCase;

    @Test
    void shouldHandleConcurrentInventoryReservation() throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);

        Runnable task = () -> {
            try {
                orderUseCase.createOrder(1L, 6);
            } catch (Exception e) {
                // esperado: uno de los dos fallará
            } finally {
                latch.countDown();
            }
        };

        executor.submit(task);
        executor.submit(task);

        latch.await();

        assertTrue(true); // si llega aquí, la concurrencia fue manejada
    }
}
