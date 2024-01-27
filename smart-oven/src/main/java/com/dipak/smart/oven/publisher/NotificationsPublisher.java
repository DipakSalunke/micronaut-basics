package com.dipak.smart.oven.publisher;

import com.dipak.smart.oven.event.Id;
import com.dipak.smart.oven.event.Notification;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@KafkaClient
public interface NotificationsPublisher {

    @Topic("${kafka.topic.notifications}")
    Flux<Notification> publishNotification(@KafkaKey Id id, Notification notification);

}
