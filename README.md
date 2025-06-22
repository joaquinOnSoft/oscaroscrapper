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
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,17859,SEAT Leon,SEAT Leon I 1.9 TDi 110cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,8817,SEAT Leon,SEAT Leon I 1.9 SDi 68cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,17856,SEAT Leon,SEAT Leon I 1.8 i Turbo 20V 180cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,8816,SEAT Leon,SEAT Leon I 1.8 i 20V 125cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,25161,SEAT Leon,SEAT Leon I 1.8 i Turbo 20V 4x4 4-Motion 180cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,12217,SEAT Leon,SEAT Leon I 2.8 i V6 Cupra R 204cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,24746,SEAT Leon,SEAT Leon I 1.9 TDi 4x4 150cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,23026,SEAT Leon,SEAT Leon I 1.9 TDi 101cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,12216,SEAT Leon,SEAT Leon I 1.9 TDi 90cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,17857,SEAT Leon,SEAT Leon I 1.8 i Turbo Cupra R 209cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,17855,SEAT Leon,SEAT Leon I 1.8 i 20V 125cv Transmisión automática,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1257,I (08/1999 - 05/2006),08/1999,05/2006,23027,SEAT Leon,SEAT Leon I 1.9 TDi 130cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,8815,SEAT Leon,SEAT Leon II 2.0 TFSi 200cv Transmisión automática,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,34018,SEAT Leon,SEAT Leon II 1.6 i LPG 102 cv,Flex Fuel
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,34021,SEAT Leon,SEAT Leon II 1.9 TDi DSG6 105 cv Transmisión automática,Diesel
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,34026,SEAT Leon,SEAT Leon II 2.0 TDi DPF 16V DSG6 170 cv Transmisión automática,Diesel
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,30440,SEAT Leon,SEAT Leon II 1.4 TFSi 16V 125 cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,47256,SEAT Leon,SEAT Leon II 2.0 TDi 16V FAP 170 cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,34020,SEAT Leon,SEAT Leon II 1.6 TDi CR DPF 105 cv,Diesel
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,30441,SEAT Leon,SEAT Leon II 1.8 TFSi DSG-7 160 cv Transmisión automática,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,17853,SEAT Leon,SEAT Leon II 2.0 TFSi 200cv,Gasolina
ma-192,SEAT,fa-723,Leon,mo-1258,II (07/2005 - 05/2010),07/2005,05/2010,12212,SEAT Leon,SEAT Leon II 2.0 TDi 136cv,Diesel
```