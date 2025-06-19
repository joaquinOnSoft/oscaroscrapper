package com.joaquinonsoft.oscaroscrapper;

import com.joaquinonsoft.oscaroscrapper.dto.Brand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.BlockingQueue;

@AllArgsConstructor
public class OscaroScrapperConsumer implements Runnable {
    private BlockingQueue<BrandJob> queue;

    @Setter(AccessLevel.NONE)
    private static final Logger log = LogManager.getLogger(OscaroScrapperConsumer.class);

    @Override
    public void run() {
        try {
            BrandJob job;
            Brand brand;
            OscaroScraper wrapper = new OscaroScraper();

            while (true) {
                job = queue.take();
                if (job.getType() == JobType.KILL_JOB || job.getType() == JobType.KILL_THEM_ALL) {
                    log.info("Consumer ending...");
                    return;
                }

                brand = job.getBrand();
                log.info("{} > {}", brand.getId(), brand.getName());
                brand = wrapper.getBrandTypes(brand);
                log.info("{}", brand.getFamilies().size());
                //TODO write brand details to CSV
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted: ", e);
            Thread.currentThread().interrupt();
        }
    }
}
