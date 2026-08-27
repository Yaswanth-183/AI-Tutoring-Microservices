# AI Tutoring Microservices

AI Tutoring Microservices is a Spring Boot-based project developed to demonstrate
the fundamentals of microservice architecture and event-driven communication.

The project consists of multiple independent Spring Boot services that
communicate through REST APIs and RabbitMQ.

## Technologies Used

- Java
- Spring Boot
- Spring Cloud
- Spring REST
- RestTemplate
- API Gateway
- RabbitMQ
- Maven
- Postman
- Eclipse IDE

## Microservices

- Customer Service
- Order Service
- Evaluation Service
- API Gateway
- Event Publisher Service
- Payment Service
- Notification Service
- Analytics Service

## Concepts Demonstrated

1. Basic Spring Boot Microservice
2. Independent Customer and Order Services
3. Service-to-Service Communication
4. API Gateway Routing
5. Publishing OrderCreated Events
6. Consuming Events using RabbitMQ
7. Publish-Subscribe Pattern
8. Work Queue with Competing Consumers
9. Retry Handling and Dead-Letter Queue
10. Order Aggregate with Order, OrderItem, and Address

## Architecture

The project demonstrates both synchronous and asynchronous
communication between microservices.

### REST Communication

Postman → API Gateway → Microservice

### RabbitMQ Communication

Producer Service → RabbitMQ → Consumer Service

For publish-subscribe:

Producer → Fanout Exchange
             ├── Notification Service
             └── Analytics Service

For work queue:

Producer → Queue
             ├── Worker 1
             └── Worker 2

## Purpose

The main purpose of this project is to understand how independent
microservices can communicate, exchange events, distribute workloads,
handle failures, and implement common enterprise messaging patterns
using Spring Boot and RabbitMQ.
