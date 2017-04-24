CREATE USER IF NOT EXISTS ROOT SALT 'df95c7b3436221f8' HASH 'd9388e1dd35dcc65a9a31bc78de49f7b892b0eefea2d045051c3a31f8017382f' ADMIN;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_5BF4F568_7391_4965_B2FD_4AEE23D6000F START WITH 3 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.CAR_SEQ START WITH 9500 INCREMENT BY 500;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_C2DA9AA7_55C4_4BBC_81E6_92B680644566 START WITH 8502 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.MODEL_SEQ START WITH 500;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_0F508347_340B_472A_9002_560C78BEE9EC START WITH 5 BELONGS_TO_TABLE;
CREATE CACHED TABLE PUBLIC.PRODUCERS(
    PRODUCER_ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_5BF4F568_7391_4965_B2FD_4AEE23D6000F) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_5BF4F568_7391_4965_B2FD_4AEE23D6000F,
    PRODUCER_NAME VARCHAR(50) NOT NULL
);
ALTER TABLE PUBLIC.PRODUCERS ADD CONSTRAINT PUBLIC.CONSTRAINT_6 PRIMARY KEY(PRODUCER_ID);
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCERS;
CREATE CACHED TABLE PUBLIC.MODELS(
    MODEL_ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_0F508347_340B_472A_9002_560C78BEE9EC) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_0F508347_340B_472A_9002_560C78BEE9EC,
    PRODUCER_ID BIGINT NOT NULL,
    MODEL_NAME VARCHAR(50) NOT NULL
);
ALTER TABLE PUBLIC.MODELS ADD CONSTRAINT PUBLIC.CONSTRAINT_8 PRIMARY KEY(MODEL_ID);
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.MODELS;
CREATE CACHED TABLE PUBLIC.CARS(
    CAR_ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_C2DA9AA7_55C4_4BBC_81E6_92B680644566) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_C2DA9AA7_55C4_4BBC_81E6_92B680644566,
    PRODUCER_ID BIGINT NOT NULL,
    MODEL_ID BIGINT NOT NULL,
    PRODUCTION_YEAR DATE,
    FUEL VARCHAR(50) NOT NULL,
    TRANSMISSION VARCHAR(50) NOT NULL
);
ALTER TABLE PUBLIC.CARS ADD CONSTRAINT PUBLIC.CONSTRAINT_1 PRIMARY KEY(CAR_ID);
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.CARS;
ALTER TABLE PUBLIC.MODELS ADD CONSTRAINT PUBLIC.CONSTRAINT_87 FOREIGN KEY(PRODUCER_ID) REFERENCES PUBLIC.PRODUCERS(PRODUCER_ID) NOCHECK;
ALTER TABLE PUBLIC.CARS ADD CONSTRAINT PUBLIC.CONSTRAINT_1F FOREIGN KEY(PRODUCER_ID) REFERENCES PUBLIC.PRODUCERS(PRODUCER_ID) NOCHECK;
ALTER TABLE PUBLIC.CARS ADD CONSTRAINT PUBLIC.CONSTRAINT_1F7 FOREIGN KEY(MODEL_ID) REFERENCES PUBLIC.MODELS(MODEL_ID) NOCHECK;

INSERT INTO PRODUCERS VALUES (1,'BMW');
INSERT INTO PRODUCERS VALUES (2, 'Audi');

INSERT INTO MODELS VALUES (1,1,'325');
INSERT INTO MODELS VALUES (2,1,'520');
INSERT INTO MODELS VALUES (3,2,'A4');
INSERT INTO MODELS VALUES (4,2,'A6');

INSERT INTO CARS VALUES (1,1,1,'01-01-2001','diesel','automatic');
INSERT INTO CARS VALUES (2,1,2,'01-01-2001','gas','automatic');
INSERT INTO CARS VALUES (3,1,1,'01-01-2001','diesel','mechanic');
INSERT INTO CARS VALUES (4,2,3,'01-01-2001','diesel','automatic');
INSERT INTO CARS VALUES (5,2,3,'01-01-2001','gasoline','mechanic');
INSERT INTO CARS VALUES (6,2,4,'01-01-2001','diesel','automatic');