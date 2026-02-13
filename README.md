# Ecommerce API

## 📌 Descripción
API REST para la gestión de órdenes e inventario, desarrollada con Spring Boot y basada en arquitectura hexagonal.

## 🏗 Arquitectura
El proyecto sigue una arquitectura hexagonal (Ports & Adapters):

- application: casos de uso y lógica de aplicación
- domain: entidades de dominio y puertos
- infrastructure: adaptadores, controladores REST y persistencia

## 🛠 Tecnologías
- Java 17
- Spring Boot
- Maven
- H2 Database (en memoria)

## 📋 Requisitos
- Java 17 o superior
- Maven 3.8+

## ▶️ Ejecución del proyecto
Clonar el repositorio y ejecutar:
```bash
mvn spring-boot:run
```

La aplicación se levantará en: http://localhost:8080

## 📦 Endpoints
Crear orden

POST /api/v1/orders

Request:{
"productId": 1,
"quantity": 2
}

Response:{
"orderId": "uuid",
"status": "INVENTORY_RESERVED"
}

## 🔄 Eventos

Cuando se crea una orden, se publica un evento de dominio para notificar la reserva de inventario.

## 📌 consideraciones

- La arquitectura sigue el enfoque hexagonal para desacoplar el dominio de la infraestructura.
- La gestión de concurrencia se apoya en transacciones y control de versiones optimista.
- Los eventos de dominio se implementan usando Spring Events. En un entorno productivo se recomienda el uso de una cola distribuida como Kafka o RabbitMQ.
- La seguridad basada en JWT no fue implementada por limitaciones de tiempo, pero el diseño contempla su integración mediante filtros de Spring Security.
- Las pruebas automatizadas no fueron incluidas debido al alcance de la prueba, pero la arquitectura facilita la creación de tests unitarios e integración.
