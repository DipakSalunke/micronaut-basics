package com.dipak.smart.oven.listener;

import com.dipak.smart.oven.event.Id;
import com.dipak.smart.oven.event.News;
import com.dipak.smart.oven.service.NewsService;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(groupId = "news.listener")
public class NewsListener {

    private NewsService newsService;

    public NewsListener(NewsService newsService) {
        this.newsService = newsService;
    }

    @Topic("${kafka.topic.news}")
    public void receive(@KafkaKey Id id, News news) {
        newsService.newsReceived(id, news);
    }
}
