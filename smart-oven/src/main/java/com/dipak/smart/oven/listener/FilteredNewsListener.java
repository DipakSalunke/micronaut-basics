package com.dipak.smart.oven.listener;

import com.dipak.smart.oven.event.Id;
import com.dipak.smart.oven.event.News;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(groupId = "notifications.listener")
public class FilteredNewsListener {

    private static final Logger logger
            = LoggerFactory.getLogger(FilteredNewsListener.class);

    @Topic("${kafka.topic.filtered-news}")
    public void receive(@KafkaKey Id id, News news) {
        logger.info("Filtered news received {}:{}",id, news);
    }
}
