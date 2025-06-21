package com.joaquinonsoft.oscaroscrapper;

import com.joaquinonsoft.oscaroscrapper.dto.Brand;
import com.joaquinonsoft.oscaroscrapper.dto.Family;
import com.joaquinonsoft.oscaroscrapper.dto.Model;
import com.joaquinonsoft.oscaroscrapper.dto.Type;
import com.joaquinonsoft.oscaroscrapper.io.CSVMerger;
import com.joaquinonsoft.oscaroscrapper.io.CSVWriter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

@AllArgsConstructor
public class OscaroScrapperConsumer implements Runnable {
    private BlockingQueue<BrandJob> queue;
    private String lang;

    @Setter(AccessLevel.NONE)
    private static final Logger log = LogManager.getLogger(OscaroScrapperConsumer.class);

    @Override
    public void run() {
        try {
            BrandJob job;
            Brand brand;
            OscaroScrapper wrapper = new OscaroScrapper(lang);

            while (true) {
                job = queue.take();

                log.info("> Job type: {} ", job.getType());

                if (job.getType() == JobType.KILL_JOB ) {
                    log.info("Consumer ending...");

                    if (queue.isEmpty()) {
                        String vehiclesFileName = "vehicles-" + lang + ".csv";
                        log.info("Merging csv files into {}...", vehiclesFileName);
                        CSVMerger.mergeCSVFiles(System.getProperty("user.dir"), vehiclesFileName);
                    }
                    
                    return;
                }

                brand = job.getBrand();
                log.info("{} > {}", brand.getId(), brand.getName());
                brand = wrapper.getBrandTypes(brand);

                writeCSV(brand);
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted: ", e);
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            log.error("Error writing merged CSV: ", e);
        }
    }

    private void writeCSV(Brand brand){
        if(brand != null) {
            String filename = brand.getName() + "-" + lang + ".csv";

            log.info("Writing vehicles CSV  file: {}", filename);

            CSVWriter writer = new CSVWriter(filename);

            String[] header = new String[]{
                    "brandId", "brandName",
                    "familyId","familyName",
                    "modelId", "modelName",
                    "typeId", "typeName", "typeFullName","energy"
            };

            writer.write(header);

            String[] line;
            for (Family family : brand.getFamilies()) {
                for (Model model : family.getModels()) {
                    for (Type type : model.getTypes()) {
                        line = new String[]{
                                brand.getId(),
                                brand.getName(),
                                family.getId(),
                                family.getName(),
                                model.getId(),
                                model.getName(),
                                type.getId(),
                                type.getName(),
                                type.getFullName(),
                                type.getEnergy()
                        };

                        writer.write(line);
                    }
                }
            }

            writer.close();
        }
    }
}
