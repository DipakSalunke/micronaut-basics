package com.dipak.smart.oven.service;

import com.dipak.smart.oven.event.Id;
import com.dipak.smart.oven.event.Notification;
import com.dipak.smart.oven.publisher.NotificationsPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class OvenService {

    private static final Logger logger
            = LoggerFactory.getLogger(OvenService.class);

    private NotificationsPublisher notificationsPublisher;

    public OvenService(NotificationsPublisher notificationsPublisher) {
        this.notificationsPublisher = notificationsPublisher;
    }

    public Flux<Notification> startOven() {
        logger.info("Starting oven ...");

        Id id = new Id();
        Notification notification = new Notification("Oven started");
        return notificationsPublisher.publishNotification(id, notification);
    }
}
