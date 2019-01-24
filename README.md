# Service Bus for Spring Applications
> Ready 2019

## Project highlights:

- The classes in [autoconfigure](qpid-jms-spring-boot/qpid-jms-spring-boot-autoconfigure/src/main/java/org/apache/qpid/jms/spring/boot/autoconfigure) will detect if a ConnectionFactory class is defined for JMS. If not, then Spring will use the classes in that directory to configure the JMS connection factory.
- There is a simple example application in [this directory](qpid-jms-spring-boot-examples/qpid-jms-spring-boot-hello-world/src/main/java/org/apache/qpid/jms/spring/boot/example).

The classes and methods have comments explaining their uses.

## Setup instructions:
1. Update `application.properties`:
    ```
    spring.qpidjms.remoteURL=amqps://<servicebus name>.servicebus.windows.net
    spring.qpidjms.username=RootManageSharedAccessKey
    spring.qpidjms.password=<primary access key>
    ```
1. Add the queue name to the producer and consumer methods
1. To build and run, enter the following commands in the top-level directory:
    1. `mvn clean install`
    1. `java -jar qpid-jms-spring-boot-examples/qpid-jms-spring-boot-hello-world/target/qpid-jms-spring-boot-hello-world-0.1.0-SNAPSHOT.jar`

The application should send and recieve one message, then stop running. Here is an example of successful output:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.4.RELEASE)

2019-01-24 14:52:48.124  INFO 64400 --- [           main] .a.q.j.s.b.e.QpidJMSSpringBootHelloWorld : Starting QpidJMSSpringBootHelloWorld v0.1.0-SNAPSHOT on jafreebe with PID 64400 (C:\Users\jafreebe\Desktop\deletethistoo\qpid-jms-spring-boot\qpid-jms-spring-boot-examples\qpid-jms-spring-boot-hello-world\target\qpid-jms-spring-boot-hello-world-0.1.0-SNAPSHOT.jar started by jafreebe in C:\Users\jafreebe\Desktop\deletethistoo\qpid-jms-spring-boot)
2019-01-24 14:52:48.132  INFO 64400 --- [           main] .a.q.j.s.b.e.QpidJMSSpringBootHelloWorld : No active profile set, falling back to default profiles: default
2019-01-24 14:52:48.222  INFO 64400 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@1e0aca6: startup date [Thu Jan 24 14:52:48 PST 2019]; root of context hierarchy
2019-01-24 14:52:49.613  INFO 64400 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2019-01-24 14:52:49.624  INFO 64400 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
2019-01-24 14:52:52.581  INFO 64400 --- [windows.net:-1]] o.a.qpid.jms.sasl.SaslMechanismFinder    : Best match for SASL auth was: SASL-PLAIN
2019-01-24 14:52:54.135  INFO 64400 --- [windows.net:-1]] org.apache.qpid.jms.JmsConnection        : Connection ID:ae4ac592-a044-44b7-b880-ce7c392bfbe0:1 connected to remote Broker: amqps://freebergBusPremium.servicebus.windows.net
2019-01-24 14:52:54.148  INFO 64400 --- [           main] o.a.q.j.s.boot.example.MessageProducer   : ============= Sending: Hello World=============

2019-01-24 14:52:54.280  INFO 64400 --- [windows.net:-1]] o.a.qpid.jms.sasl.SaslMechanismFinder    : Best match for SASL auth was: SASL-PLAIN
2019-01-24 14:52:54.357  INFO 64400 --- [windows.net:-1]] org.apache.qpid.jms.JmsConnection        : Connection ID:e2f18d2d-d35a-43b6-a577-74b988f52b46:2 connected to remote Broker: amqps://freebergBusPremium.servicebus.windows.net
2019-01-24 14:52:54.508  INFO 64400 --- [enerContainer-1] o.a.q.j.s.boot.example.MessageConsumer   : ============= Received: Hello World =============

2019-01-24 14:52:54.589  INFO 64400 --- [           main] .a.q.j.s.b.e.QpidJMSSpringBootHelloWorld : Started QpidJMSSpringBootHelloWorld in 6.998 seconds (JVM running for 7.485)
```