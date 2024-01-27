package com.dipak.cloud.service.scheduler;

import com.dipak.cloud.service.event.News;
import com.dipak.cloud.service.event.Id;
import com.dipak.cloud.service.publisher.NewsPublisher;
import io.micronaut.scheduling.annotation.Scheduled;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Singleton;
import java.util.UUID;

@Singleton
public class NewsScheduler {

    private static final Logger logger
            = LoggerFactory.getLogger(NewsScheduler.class);

    private NewsPublisher newsPublisher;

    public NewsScheduler(NewsPublisher newsPublisher) {
        this.newsPublisher = newsPublisher;
    }

    @Scheduled(fixedRate = "5s")
    public void publishNews() {
        Id id = new Id(UUID.randomUUID());

        String title = RandomStringUtils.randomAlphabetic(2);
        String description = RandomStringUtils.randomAlphabetic(10);
        News news = new News(title, description);

        logger.info("Publishing news {}:{}", id, news);
        newsPublisher.publishNews(id, news);
    }


}
