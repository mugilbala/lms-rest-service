-- DDL Script to Initialize database tables for LMS Apis

-- SEQUENCE: public.tbl_lms_batch_batch_id_seq

-- DROP SEQUENCE IF EXISTS public.tbl_lms_batch_batch_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.tbl_lms_batch_batch_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY tbl_lms_batch.batch_id;

ALTER SEQUENCE public.tbl_lms_batch_batch_id_seq
    OWNER TO postgres;

-- Table: public.tbl_lms_batch

-- DROP TABLE IF EXISTS public.tbl_lms_batch;

CREATE TABLE IF NOT EXISTS public.tbl_lms_batch
(
    batch_id integer NOT NULL DEFAULT nextval('tbl_lms_batch_batch_id_seq'::regclass),
    batch_name character varying COLLATE pg_catalog."default" NOT NULL,
    batch_description character varying COLLATE pg_catalog."default",
    batch_status character varying COLLATE pg_catalog."default" NOT NULL DEFAULT 'ACTIVE'::character varying,
    batch_program_id integer NOT NULL,
    batch_no_of_classes integer NOT NULL DEFAULT 1,
    creation_time timestamp without time zone NOT NULL DEFAULT now(),
    last_mod_time timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT batch_id_pk PRIMARY KEY (batch_id),
    CONSTRAINT tbl_lms_batch_batch_name_batch_program_id_key UNIQUE (batch_name, batch_program_id),
    CONSTRAINT batch_fk FOREIGN KEY (batch_program_id)
        REFERENCES public.tbl_lms_program (program_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tbl_lms_batch
    OWNER to postgres;

-- SEQUENCE: public.tbl_lms_program_program_id_seq

-- DROP SEQUENCE IF EXISTS public.tbl_lms_program_program_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.tbl_lms_program_program_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY tbl_lms_program.program_id;

ALTER SEQUENCE public.tbl_lms_program_program_id_seq
    OWNER TO postgres;

-- Table: public.tbl_lms_program

-- DROP TABLE IF EXISTS public.tbl_lms_program;

CREATE TABLE IF NOT EXISTS public.tbl_lms_program
(
    program_id integer NOT NULL DEFAULT nextval('tbl_lms_program_program_id_seq'::regclass),
    program_name character varying COLLATE pg_catalog."default" NOT NULL,
    program_description character varying COLLATE pg_catalog."default",
    program_status character varying COLLATE pg_catalog."default" NOT NULL DEFAULT 'ACTIVE'::character varying,
    creation_time timestamp without time zone NOT NULL DEFAULT now(),
    last_mod_time timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT program_id_pk PRIMARY KEY (program_id),
    CONSTRAINT tbl_lms_program_program_name_key UNIQUE (program_name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tbl_lms_program
    OWNER to postgres;
