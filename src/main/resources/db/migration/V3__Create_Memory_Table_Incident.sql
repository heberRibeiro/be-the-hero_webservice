CREATE MEMORY TABLE "PUBLIC"."INCIDENT"(
    "ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_D1FADFBB_8701_435F_AB7B_C2798C6F7BDE" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_D1FADFBB_8701_435F_AB7B_C2798C6F7BDE",
    "DESCRIPTION" VARCHAR(MAX),
    "TITLE" VARCHAR(255),
    "VALUE" DOUBLE,
    "ONG_ID" INTEGER
);
ALTER TABLE "PUBLIC"."INCIDENT" ADD CONSTRAINT "PUBLIC"."FKH78T3IL065XL481EQJET1JXDU" FOREIGN KEY("ONG_ID") REFERENCES "PUBLIC"."ONG"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."INCIDENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID");