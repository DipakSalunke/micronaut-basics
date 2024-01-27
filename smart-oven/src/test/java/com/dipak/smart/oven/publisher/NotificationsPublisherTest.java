package com.dipak.smart.oven.publisher;

import com.dipak.smart.oven.common.KafkaBaseTest;
import com.dipak.smart.oven.common.NotificationsTestListener;
import com.dipak.smart.oven.event.Id;
import com.dipak.smart.oven.event.Notification;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import jakarta.inject.Inject;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NotificationsPublisherTest extends KafkaBaseTest {

    @Inject
    NotificationsTestListener notificationsListener;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    @DisplayName("Should publish notification successfully")
    void shouldPublishNotificationSuccessfully() throws InterruptedException {
        //GIVEN
        HttpRequest request = HttpRequest.GET("/oven/start");

        //WHEN
        HttpResponse<Notification> response =
                client.toBlocking().exchange(request, Notification.class);
        notificationsListener.getLatch().await(3000, TimeUnit.MILLISECONDS);

        //THEN
        Map<Id, Notification> events = notificationsListener.getEvents();
        assertEquals(1, events.size());
    }
}
