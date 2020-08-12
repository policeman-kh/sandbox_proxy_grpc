# Sandbox for proxy gRPC with nginx and envoy

To learn the difference between nginx and envoy.

## Preparation
* Install JDK11
* Install Intellij and open this as project.
* Install Docker
* Install grpcurl for testing.

## Architecture

<pre>
client -- port:8081 --> nginx -- port:8080 --> grpc server <br>
    +---- port:8082 --> envoy -- port:8080 -----+ 
</pre>

- Running each nginx and envoy on docker container .
- Running grpc server on host OS. The IP address of host OS is "192.168.0.163".

# Run applications.

### grpc server

```
$ ./gradlew bootRun
```

- Run connection test by the following command. 

```
$ grpcurl -plaintext -d '{"name": "aaaa"}' localhost:8080 HelloService/Hello
```

### nginx

```
$ docker-compose -f docker-compose-nginx.yml up -d 
```

- Run connection test by the following command. 

```
$ grpcurl -plaintext -d '{"name": "aaaa"}' localhost:8081 HelloService/Hello
```

### envoy

```
$ docker-compose -f docker-compose-envoy.yml up -d 
```

- Run connection test by the following command. 

```
$ grpcurl -plaintext -d '{"name": "aaaa"}' localhost:8082 HelloService/Hello
```



