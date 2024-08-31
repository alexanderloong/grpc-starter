package vn.all.grpcclient;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.all.grpcserver.proto.GreeterGrpc;
import vn.all.grpcserver.proto.HelloRequest;

@SpringBootApplication
@Slf4j
public class GrpcClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Bean
    ApplicationRunner clientRunner(@GrpcClient("helloService") GreeterGrpc.GreeterBlockingStub blockingStub) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
               log.info(blockingStub.sayHello(HelloRequest.newBuilder().setName("Alexander Loong").build()).getMessage());
            }
        };
    }

}
