package com.example.feignnative;

import feign.RequestLine;

public interface Client {
    @RequestLine("GET /data")
    Data getData();
}
