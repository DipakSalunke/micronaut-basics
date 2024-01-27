package com.dipak.smart.oven.client;

import com.dipak.smart.oven.dto.calibration.CalibrationParameters;
import com.dipak.smart.oven.dto.calibration.CalibrationStatus;
import com.dipak.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.micronaut.retry.annotation.Fallback;
import reactor.core.publisher.Mono;

@Fallback
public class CalibrationsClientFallback implements DeclarativeCalibrationsClient {

    @Override
    public Mono<CalibrationParameters> getCalibrationParameters(String modelName) {
        return Mono.just(new CalibrationParameters(modelName, 0, 0));
    }

    @Override
    public Mono<CalibrationUpdateResult> updateCalibrationParameters(CalibrationStatus calibrationStatus) {
        return Mono.just(new CalibrationUpdateResult(false));
    }
}
