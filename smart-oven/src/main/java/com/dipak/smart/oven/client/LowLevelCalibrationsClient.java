package com.dipak.smart.oven.client;

import com.dipak.smart.oven.dto.calibration.CalibrationParameters;
import com.dipak.smart.oven.dto.calibration.CalibrationStatus;
import com.dipak.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;

@Singleton
public class LowLevelCalibrationsClient {

    private static final Logger logger
            = LoggerFactory.getLogger(LowLevelCalibrationsClient.class);

    private HttpClient client;

    public LowLevelCalibrationsClient(@Client("http://localhost:8020") HttpClient client) {
        this.client = client;
    }

    public Flux<CalibrationParameters> getCalibrationParameters(String modelName) {
        logger.info("Calling GET calibration parameters using the low-level client for model {}", modelName);
      return Flux.from(client.retrieve(HttpRequest.GET("/calibrations/" + modelName),
                        CalibrationParameters.class));
    }

    public Flux<CalibrationUpdateResult> updateCalibrationStatus(CalibrationStatus calibrationStatus) {
        logger.info("Calling PUT calibration updates using the low-level client with {}", calibrationStatus);
        return  Flux.from(client.retrieve(HttpRequest.PUT("/calibrations/updates", calibrationStatus),
                CalibrationUpdateResult.class));
    }
}
