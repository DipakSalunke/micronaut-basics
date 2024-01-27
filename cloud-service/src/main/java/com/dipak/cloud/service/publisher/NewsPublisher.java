package com.dipak.cloud.service.publisher;

import com.dipak.cloud.service.event.News;
import com.dipak.cloud.service.event.Id;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface NewsPublisher {

    @Topic("news")
    void publishNews(@KafkaKey Id id, News news);

}
