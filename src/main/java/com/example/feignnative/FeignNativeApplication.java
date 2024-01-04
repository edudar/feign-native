package com.example.feignnative;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class FeignNativeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FeignNativeApplication.class, args);
    }

    @Autowired
    Client client;

    @Override
    public void run(String... args) throws Exception {
        var server = HttpServer.create(
                new InetSocketAddress("localhost", 9001),
                10, "/data", HttpHandlers.of(
                        200,
                        Headers.of("Content-Type", "application/json"),
                        """
                                {"id": "id1", "name": "name1"}
                                """));
        server.start();
        try {
            var data = client.getData();
            System.out.println(data);
        } finally {
            server.stop(1);
        }
    }
}
