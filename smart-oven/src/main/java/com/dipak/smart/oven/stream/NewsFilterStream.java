package com.dipak.smart.oven.stream;

import io.micronaut.configuration.kafka.streams.ConfiguredStreamBuilder;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Property;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import jakarta.inject.Named;
import jakarta.inject.Singleton;
import java.util.Properties;

@Factory
public class NewsFilterStream {


    @Property(name = "kafka.topic.news")
    private String news;

    @Property(name = "kafka.topic.filtered-news")
    private String filteredNews;

    private static final String FILTER = "z";

    @Singleton
    @Named("news-filter")
    KStream<String, String> newsFilterStream(ConfiguredStreamBuilder builder) {
        Properties props = builder.getConfiguration();
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStream<String, String> source = builder.stream(news);

        source.filter((key, value) -> value.contains(FILTER))
                .to(filteredNews);

        return source;
    }
}
