package com.dipak.smart.oven.common;

import com.dipak.smart.oven.event.Id;
import com.dipak.smart.oven.event.News;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import reactor.core.publisher.Mono;


@KafkaClient
public interface NewsTestPublisher {

    @Topic("${kafka.topic.news}")
    Mono<News> publishNews(@KafkaKey Id id, News news);
}
