# Java-bitly
Java Spring Boot, Mokito, RabbitMQ, Swagger, Docker and all in one short and sweet project

### Local RabbitMQ setup

After installing rabbitmq start with
```/usr/local/sbin/rabbitmq-server```

### Swagger API - Documentation

API Docs ```http://localhost:8080/swagger-ui.html#/links-controller```

### Local MySQL setup

After installing mysql with
```brew install mysql ```

start mysql with 
```/usr/local/bin/mysql.server start```

```CREATE DATABASE urls``` 
```CREATE TABLE links(short_url varchar(255) NOT NULL PRIMARY KEY,full_url VARCHAR(255));```

Add click count column: 
```ALTER TABLE link ADD click_count int```
