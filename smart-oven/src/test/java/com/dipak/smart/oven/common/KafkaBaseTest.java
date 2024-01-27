package com.dipak.smart.oven.common;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.test.support.TestPropertyProvider;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

public class KafkaBaseTest implements TestPropertyProvider {

    protected static final KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka"));

    @NonNull
    @Override
    public Map<String, String> getProperties() {
        return Map.of("kafka.bootstrap.servers", kafka.getBootstrapServers());
    }

    static {
        kafka.start();
    }
}
