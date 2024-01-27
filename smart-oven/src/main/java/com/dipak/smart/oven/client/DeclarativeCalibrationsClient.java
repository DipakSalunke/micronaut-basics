package com.dipak.smart.oven.client;

import com.dipak.smart.oven.dto.calibration.CalibrationParameters;
import com.dipak.smart.oven.dto.calibration.CalibrationStatus;
import com.dipak.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

@Client("http://localhost:8020")
public interface DeclarativeCalibrationsClient {

    @Get("/calibrations/{modelName}")
//    @Retryable(attempts = "3", delay = "2s")
//    @CircuitBreaker
    Mono<CalibrationParameters> getCalibrationParameters(String modelName);

    @Put("/calibrations/updates")
    Mono<CalibrationUpdateResult> updateCalibrationParameters(@Body CalibrationStatus calibrationStatus);

}
