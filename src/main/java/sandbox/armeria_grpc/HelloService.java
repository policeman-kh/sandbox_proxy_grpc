package sandbox.armeria_grpc;

import reactor.core.publisher.Mono;
import sandbox.armeria_grpc.Hello.HelloRequest;
import sandbox.armeria_grpc.Hello.HelloResponse;

public class HelloService extends ReactorHelloServiceGrpc.HelloServiceImplBase {
    @Override
    public Mono<HelloResponse> hello(Mono<HelloRequest> request) {
        return request.map(in -> HelloResponse.newBuilder()
                                              .setMessage(in.getName())
                                              .build());
    }
}
