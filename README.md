# Oscaro Scrapper

Scrapping command line tool to get the brands, families, models and type of vehicles

Generate a csv file for each brand. The file name includes the brand name plus the language (ISO code 2).

Example `SEAT-es.csv`:

```csv
brandId,brandName,familyId,familyName,modelId,modelName,manufacturedFrom,manufacturedTo,typeId,typeName,typeFullName,energy
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,12215,SEAT Leon,SEAT Leon I 1.6 i 16V 105cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,17858,SEAT Leon,SEAT Leon I 1.8 i Turbo Cupra R 225cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,12219,SEAT Leon,SEAT Leon I Syncro 1.9 TDi 150cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,23025,SEAT Leon,SEAT Leon I 1.6 i 100cv Transmisión automática,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,23024,SEAT Leon,SEAT Leon I 1.6 i 100cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,17854,SEAT Leon,SEAT Leon I 1.4 i 16V 75cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,12214,SEAT Leon,SEAT Leon I 1.6 i 102cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,8818,SEAT Leon,SEAT Leon I 1.9 TDi 150cv,Diesel
```

## How to execute the tool?

Once you have compiled and generated the `.jar` file  you can execute it using these options:

 - `--thread` or `-t`: Number of threads used to run the app. Default value: 4
 - `--lang` or `-l`: Language code (ISO 2) used to recover the information. 
    Valid values: (`es`, `fr` and `pt`). `es` is the default value    


Example of execution:

```console
java -jar .\OscaroScrapper25.06.24.jar --thread 8 -lang fr
```
