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
public class OscaroScrapperProducer implements Runnable{
    private BlockingQueue<BrandJob> queue;
    private int numConsumers;

    @Setter(AccessLevel.NONE)
    private static final Logger log = LogManager.getLogger(OscaroScrapperProducer.class);

    @Override
    public void run() {
        OscaroScraper wrapper = new OscaroScraper();
        List<Brand> brands = wrapper.getBrands();

        if(brands != null){
            for (Brand brand: brands){
                log.info("{} added.", brand.getName());
                queue.add(new BrandJob(JobType.BRAND, brand));
            }
        }

        for(int i=0; i<(numConsumers-1); i++) {
            log.info("Consumer {} launched.", i);
            queue.add(new BrandJob(JobType.KILL_JOB));
        }
        queue.add(new BrandJob(JobType.KILL_THEM_ALL));
    }
}
