package com.dipak.smart.oven.controller;


import com.dipak.smart.oven.dto.calibration.CalibrationUpdateResult;
import com.dipak.smart.oven.service.CalibrationsService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/calibrations")
public class CalibrationsController {

    private static final Logger logger
            = LoggerFactory.getLogger(CalibrationsController.class);

    private CalibrationsService calibrationsService;

    public CalibrationsController(CalibrationsService calibrationsService) {
        this.calibrationsService = calibrationsService;
    }

    @Get("/calibrate")
    public Flux<CalibrationUpdateResult> calibrateOven() {
        return calibrationsService.calibrateOven();
    }

    @Get("/calibrate/declarative")
    public Mono<CalibrationUpdateResult> calibrateOvenUsingDeclarativeClient() {
        return calibrationsService.calibrateOvenUsingDeclarativeClient();
    }
}
