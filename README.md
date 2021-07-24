# Email-Sender-With-Spring-Cloud

This repository contains producer and consumer microsevises connected with Spring Cloud/Netflix technologies, Zuul as gateway service and Eureka as service discovery.

Producer uses Feign Client to send JSON/String message, which contains user mail, to consumer. 

Consumer receives this JSON/String message, which contains mail, and sends email on this mail.

Email sending was tested using https://mailtrap.io
