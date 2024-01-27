package com.dipak.smart.oven.common;

import com.dipak.smart.oven.event.Id;
import com.dipak.smart.oven.event.Notification;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@KafkaListener(groupId = "notifications.test.listener")
public class NotificationsTestListener {

    private CountDownLatch latch = new CountDownLatch(1);

    private Map<Id, Notification> events = new HashMap<>();

    @Topic("${kafka.topic.notifications}")
    public void notificationPublished(@KafkaKey Id id, Notification notification) {
        events.put(id, notification);
        latch.countDown();
    }

    public CountDownLatch getLatch() { return latch; }

    public Map<Id, Notification> getEvents() { return events; }
}
