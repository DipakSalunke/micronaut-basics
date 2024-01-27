package com.dipak.smart.oven.controller;

import com.dipak.smart.oven.event.Notification;
import com.dipak.smart.oven.service.OvenService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/oven")
public class OvenController {

    private OvenService ovenService;

    public OvenController(OvenService ovenService) {
        this.ovenService = ovenService;
    }

    @Get("/start")
    public Flux<Notification> startOven() {
        return ovenService.startOven();
    }

}
