# Email-Sender-with-Kafka

This repository contains three projects. The first one is common files for both projects, the second one is producer, and the third one is consumer. 

Producer uses Spring Boot with Spring Kafka to publish JSON/String message, which contains user mail, to a Kafka topic. 

Consumer receives this JSON/String message, which contains mail, from Kafka and sends email on this mail.

Email sending was tested using https://mailtrap.io

To start Zookeeper and Kafka, use this commands: 

```
.\bin\windows\zookeeper-server-start.bat config\zookeeper.properties

.\bin\windows\kafka-server-start.sh config\server.properties

.\bin\windows\kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic NewTopic --from-beginning
```

Start producer and consumer projects. Enter app for API testing (such as Postman) and send POST query with body which contains mail to this adress: 
```
localhost:8081/publish
```

If everything's OK, the email testing program would show you the mail sent on the email you've notified.


