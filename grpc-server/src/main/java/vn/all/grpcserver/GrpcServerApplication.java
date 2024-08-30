package vn.all.grpcserver;

import io.grpc.Server;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class GrpcServerApplication {

    private final Server server;

    public GrpcServerApplication(Server server) {
        this.server = server;
    }

    public static void main(String[] args) {
        SpringApplication.run(GrpcServerApplication.class, args);
    }

    @PostConstruct
    public void start() throws IOException {
        server.start();
        log.info("gRPC server started, listening on {}", server.getPort());
    }

    @PreDestroy
    public void stop() throws InterruptedException {
        server.shutdown().awaitTermination();
    }

}
