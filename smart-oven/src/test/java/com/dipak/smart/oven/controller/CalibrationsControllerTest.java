package com.dipak.smart.oven.controller;

import com.dipak.smart.oven.client.DeclarativeCalibrationsClient;
import com.dipak.smart.oven.dto.calibration.CalibrationParameters;
import com.dipak.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class CalibrationsControllerTest {

    @MockBean(DeclarativeCalibrationsClient.class)
    DeclarativeCalibrationsClient calibrationsClient() {
        return mock(DeclarativeCalibrationsClient.class);
    }

    @Inject
    DeclarativeCalibrationsClient calibrationsClient;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    @DisplayName("Should calibrate oven successfully")
    void shouldCalibrateOvenSuccessfully() {
        //GIVEN
        CalibrationParameters calibrationParameters = new CalibrationParameters("Model", 100, 500);
        when(calibrationsClient.getCalibrationParameters(any())).thenReturn(Mono.just(calibrationParameters));

        CalibrationUpdateResult calibrationUpdateResult = new CalibrationUpdateResult(true);
        when(calibrationsClient.updateCalibrationParameters(any())).thenReturn(Mono.just(calibrationUpdateResult));

        HttpRequest request = HttpRequest.GET("/calibrations/calibrate/declarative");

        //WHEN
        HttpResponse<CalibrationUpdateResult> response =
                client.toBlocking().exchange(request, CalibrationUpdateResult.class);

        //THEN
        assertEquals(HttpStatus.OK, response.getStatus());
        assertTrue(response.body().getSuccess());
    }
}
