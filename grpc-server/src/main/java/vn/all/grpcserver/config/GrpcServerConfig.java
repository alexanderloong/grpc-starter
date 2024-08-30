package vn.all.grpcserver.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.all.grpcserver.service.HelloService;

@Configuration
public class GrpcServerConfig {

    @Value("${grpc.server.port}")
    private int port;

    @Bean
    public Server grpcServer(HelloService greeterService) {
        return ServerBuilder.forPort(port)
                .addService(greeterService)
                .build();
    }

}
