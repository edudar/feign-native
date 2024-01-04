package com.example.feignnative;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration
@ImportRuntimeHints(FeignHints.class)
@RegisterReflectionForBinding(Data.class)
public class Config {

    @Bean
    Client client() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(Client.class, "http://localhost:9001/");
    }

}
