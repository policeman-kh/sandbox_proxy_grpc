package sandbox.armeria_grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.linecorp.armeria.common.grpc.GrpcSerializationFormats;
import com.linecorp.armeria.server.grpc.GrpcService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;

import io.grpc.protobuf.services.ProtoReflectionService;

@SpringBootApplication
public class ArmeriaGrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmeriaGrpcApplication.class, args);
    }

    @Bean
    public ArmeriaServerConfigurator services() {
        return sb -> sb.service(
                GrpcService.builder()
                           .addService(new HelloService())
                           .addService(ProtoReflectionService.newInstance())
                           .supportedSerializationFormats(GrpcSerializationFormats.values())
                           .enableUnframedRequests(true)
                           .build());
    }
}
