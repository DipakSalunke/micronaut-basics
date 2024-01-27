package com.dipak.smart.oven.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;

public class NotFoundController {

    @Get("/404")
    public HttpResponse notFoundController() {
        return HttpResponse.notFound();
    }
}
