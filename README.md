## Project workflow:

<br>![rabbitmq workflow](https://github.com/cristimanolache28/springboot-rabbitmq-microservices/assets/49694359/cc534bdc-13bd-4e07-9c58-67580e52cfa8)</br>

## How the project works ? 
In the above photo we can see the entire project workflow. The projet contains **three microservices** (Order Service, Stock Service, Email Service), **an exchange** that use two different **routes** and **two queues**. The microservices are divided into microservices that **produces messages** and **microservices that consume that messages**. The Order Service application is a producer that receives a message and sends the message to an exchange, the exchange after receiving the message will send to a queue based on the routing key. Queued messages can be retrieved by consumers (Stock Service and Mail Service) only once. After a message is retrieved, it will be deleted from the queue.

## RabbitMQ vs Kafka
Well, both RabbitMQ and Apache Kafka are popular message brokers that can handle long-running tasks, but they have different design philosophies and use cases.

RabbitMQ is a traditional message broker that is optimized for reliability and ease of use. It supports multiple messaging protocols and provides features like message queuing, routing, and delivery guarantees. RabbitMQ is commonly used in enterprise environments for mission-critical applications that require high availability and fault tolerance.

Apache Kafka, on the other hand, is a distributed streaming platform that is optimized for scalability and high throughput. It is designed to handle large volumes of data in real time and supports features like event streaming, message replay, and distributed processing. Apache Kafka is commonly used for big data applications, IoT, and real-time analytics.

If your application requires high reliability and ease of use, RabbitMQ may be a better choice. If your application requires high scalability and real-time processing of large volumes of data, Apache Kafka may be a better choice.



