package com.global.book.datajpabooksproject.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class DiscountScheduled {
    Logger logger = LoggerFactory.getLogger(DiscountScheduled.class);
    @Scheduled(fixedRate = 2000)
    @Async
    @SchedulerLock(name = "computePrice")
    public void computePrice() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("compute price >> " + LocalDateTime.now());
    }
    @Scheduled(fixedRate = 2000)
    @Async
    @SchedulerLock(name = "computeDiscount")
    public void computeDiscount() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("compute discount >> " + LocalDateTime.now());
    }
}
