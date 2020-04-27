--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: access; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.access (
    animal_id integer NOT NULL,
    access_employee_id integer NOT NULL,
    access_start_date date NOT NULL
);


ALTER TABLE public.access OWNER TO postgres;

--
-- Name: access_worker; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.access_worker (
    id integer NOT NULL,
    employee_id integer
);


ALTER TABLE public.access_worker OWNER TO postgres;

--
-- Name: access_worker_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.access_worker_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.access_worker_id_seq OWNER TO postgres;

--
-- Name: access_worker_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.access_worker_id_seq OWNED BY public.access_worker.id;



CREATE TABLE public.animal (
    id integer NOT NULL,
    cage_id integer,
    species_id integer,
    date_of_birth date NOT NULL,
    gender text NOT NULL,
    physical_state boolean NOT NULL,
    hospital boolean,
    reciept_date date NOT NULL,
    number_of_offspring integer,
    CONSTRAINT animal_number_of_offspring_check CHECK ((number_of_offspring >= 0))
);


ALTER TABLE public.animal OWNER TO postgres;

--
-- Name: animal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.animal_id_seq OWNER TO postgres;

--
-- Name: animal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.animal_id_seq OWNED BY public.animal.id;


--
-- Name: assortment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.assortment (
    provider_id integer NOT NULL,
    feed_id integer NOT NULL
);


ALTER TABLE public.assortment OWNER TO postgres;

--
-- Name: builder_worker; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.builder_worker (
    id integer NOT NULL,
    employee_id integer,
    building_for_repair integer
);


ALTER TABLE public.builder_worker OWNER TO postgres;

--
-- Name: builder_worker_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.builder_worker_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.builder_worker_id_seq OWNER TO postgres;

--
-- Name: builder_worker_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.builder_worker_id_seq OWNED BY public.builder_worker.id;


--
-- Name: cage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cage (
    id integer NOT NULL,
    inmate boolean
);


ALTER TABLE public.cage OWNER TO postgres;

--
-- Name: cage_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cage_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cage_id_seq OWNER TO postgres;

--
-- Name: cage_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cage_id_seq OWNED BY public.cage.id;


--
-- Name: cleaner; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cleaner (
    id integer NOT NULL,
    access_worker_id integer,
    pantry_number integer NOT NULL,
    CONSTRAINT cleaner_pantry_number_check CHECK ((pantry_number > 0))
);


ALTER TABLE public.cleaner OWNER TO postgres;

--
-- Name: cleaner_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cleaner_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cleaner_id_seq OWNER TO postgres;

--
-- Name: cleaner_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cleaner_id_seq OWNED BY public.cleaner.id;


--
-- Name: compatibility; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compatibility (
    first_species_id integer NOT NULL,
    second_species_id integer NOT NULL
);


ALTER TABLE public.compatibility OWNER TO postgres;



--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id integer NOT NULL,
    name text NOT NULL,
    surname text NOT NULL,
    work_start_date date NOT NULL,
    gender text NOT NULL,
    monthly_salary integer NOT NULL,
    CONSTRAINT employee_monthly_salary_check CHECK ((monthly_salary > 0))
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;


--
-- Name: exchange; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exchange (
    zoo_id integer NOT NULL,
    animal_id integer NOT NULL,
    side boolean NOT NULL
);


ALTER TABLE public.exchange OWNER TO postgres;

--
-- Name: feed; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.feed (
    id integer NOT NULL,
    name text NOT NULL,
    type text NOT NULL
);


ALTER TABLE public.feed OWNER TO postgres;

--
-- Name: feed_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.feed_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.feed_id_seq OWNER TO postgres;

--
-- Name: feed_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.feed_id_seq OWNED BY public.feed.id;


--
-- Name: illness; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.illness (
    id integer NOT NULL,
    name text NOT NULL,
    graft text
);


ALTER TABLE public.illness OWNER TO postgres;

--
-- Name: illness_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.illness_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.illness_id_seq OWNER TO postgres;

--
-- Name: illness_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.illness_id_seq OWNED BY public.illness.id;


--
-- Name: illness_on_medical_examination; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.illness_on_medical_examination (
    illness_id integer NOT NULL,
    medical_examination_id integer NOT NULL
);


ALTER TABLE public.illness_on_medical_examination OWNER TO postgres;

--
-- Name: medical_examination; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medical_examination (
    id integer NOT NULL,
    animal_id integer,
    vet_id integer,
    weight integer NOT NULL,
    height integer NOT NULL,
    CONSTRAINT medical_examination_height_check CHECK ((height > 0)),
    CONSTRAINT medical_examination_weight_check CHECK ((weight > 0))
);


ALTER TABLE public.medical_examination OWNER TO postgres;

--
-- Name: medical_examination_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medical_examination_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medical_examination_id_seq OWNER TO postgres;

--
-- Name: medical_examination_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medical_examination_id_seq OWNED BY public.medical_examination.id;


--
-- Name: neighborhood; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.neighborhood (
    first_cage_id integer NOT NULL,
    second_cage_id integer NOT NULL
);


ALTER TABLE public.neighborhood OWNER TO postgres;

--
-- Name: provider; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.provider (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.provider OWNER TO postgres;

--
-- Name: provider_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.provider_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.provider_id_seq OWNER TO postgres;

--
-- Name: provider_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.provider_id_seq OWNED BY public.provider.id;


--
-- Name: species; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.species (
    id integer NOT NULL,
    name text,
    type text NOT NULL,
    need_warm_place boolean NOT NULL,
    age_for_childbirth integer NOT NULL,
    CONSTRAINT species_age_for_childbirth_check CHECK ((age_for_childbirth > 0))
);


ALTER TABLE public.species OWNER TO postgres;

--
-- Name: species_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.species_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.species_id_seq OWNER TO postgres;

--
-- Name: species_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.species_id_seq OWNED BY public.species.id;


--
-- Name: supply; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supply (
    id integer NOT NULL,
    provider_id integer NOT NULL,
    feed_id integer NOT NULL,
    supply_date date NOT NULL,
    feed_amount integer NOT NULL,
    price integer NOT NULL,
    CONSTRAINT supply_feed_amount_check CHECK ((feed_amount > 0)),
    CONSTRAINT supply_price_check CHECK ((price > 0))
);


ALTER TABLE public.supply OWNER TO postgres;

--
-- Name: supply_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supply_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.supply_id_seq OWNER TO postgres;

--
-- Name: supply_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supply_id_seq OWNED BY public.supply.id;


--
-- Name: vet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vet (
    id integer NOT NULL,
    access_worker_id integer,
    laboratory_number integer NOT NULL,
    CONSTRAINT vet_laboratory_number_check CHECK ((laboratory_number > 0))
);


ALTER TABLE public.vet OWNER TO postgres;

--
-- Name: vet_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vet_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vet_id_seq OWNER TO postgres;

--
-- Name: vet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vet_id_seq OWNED BY public.vet.id;


--
-- Name: zoo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zoo (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.zoo OWNER TO postgres;

--
-- Name: zoo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zoo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zoo_id_seq OWNER TO postgres;

--
-- Name: zoo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.zoo_id_seq OWNED BY public.zoo.id;


--
-- Name: access_worker id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.access_worker ALTER COLUMN id SET DEFAULT nextval('public.access_worker_id_seq'::regclass);


--
-- Name: animal id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animal ALTER COLUMN id SET DEFAULT nextval('public.animal_id_seq'::regclass);


--
-- Name: builder_worker id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.builder_worker ALTER COLUMN id SET DEFAULT nextval('public.builder_worker_id_seq'::regclass);


--
-- Name: cage id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cage ALTER COLUMN id SET DEFAULT nextval('public.cage_id_seq'::regclass);


--
-- Name: cleaner id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cleaner ALTER COLUMN id SET DEFAULT nextval('public.cleaner_id_seq'::regclass);


--
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);


--
-- Name: feed id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.feed ALTER COLUMN id SET DEFAULT nextval('public.feed_id_seq'::regclass);


--
-- Name: illness id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illness ALTER COLUMN id SET DEFAULT nextval('public.illness_id_seq'::regclass);


--
-- Name: medical_examination id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_examination ALTER COLUMN id SET DEFAULT nextval('public.medical_examination_id_seq'::regclass);


--
-- Name: provider id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provider ALTER COLUMN id SET DEFAULT nextval('public.provider_id_seq'::regclass);


--
-- Name: species id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.species ALTER COLUMN id SET DEFAULT nextval('public.species_id_seq'::regclass);


--
-- Name: supply id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supply ALTER COLUMN id SET DEFAULT nextval('public.supply_id_seq'::regclass);



--
-- Name: vet id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vet ALTER COLUMN id SET DEFAULT nextval('public.vet_id_seq'::regclass);


--
-- Name: zoo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zoo ALTER COLUMN id SET DEFAULT nextval('public.zoo_id_seq'::regclass);


--
-- Data for Name: access; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: access access_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.access
    ADD CONSTRAINT access_pkey PRIMARY KEY (animal_id, access_employee_id);


--
-- Name: access_worker access_worker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.access_worker
    ADD CONSTRAINT access_worker_pkey PRIMARY KEY (id);

--
-- Name: animal animal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (id);


--
-- Name: assortment assortment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assortment
    ADD CONSTRAINT assortment_pkey PRIMARY KEY (provider_id, feed_id);


--
-- Name: builder_worker builder_worker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.builder_worker
    ADD CONSTRAINT builder_worker_pkey PRIMARY KEY (id);


--
-- Name: cage cage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cage
    ADD CONSTRAINT cage_pkey PRIMARY KEY (id);


--
-- Name: cleaner cleaner_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cleaner
    ADD CONSTRAINT cleaner_pkey PRIMARY KEY (id);


--
-- Name: compatibility compatibility_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compatibility
    ADD CONSTRAINT compatibility_pkey PRIMARY KEY (first_species_id, second_species_id);

--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: exchange exchange_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exchange
    ADD CONSTRAINT exchange_pkey PRIMARY KEY (zoo_id, animal_id);


--
-- Name: feed feed_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.feed
    ADD CONSTRAINT feed_pkey PRIMARY KEY (id);


--
-- Name: illness illness_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illness
    ADD CONSTRAINT illness_name_key UNIQUE (name);


--
-- Name: illness_on_medical_examination illness_on_medical_examination_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illness_on_medical_examination
    ADD CONSTRAINT illness_on_medical_examination_pkey PRIMARY KEY (illness_id, medical_examination_id);


--
-- Name: illness illness_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illness
    ADD CONSTRAINT illness_pkey PRIMARY KEY (id);


--
-- Name: medical_examination medical_examination_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_examination
    ADD CONSTRAINT medical_examination_pkey PRIMARY KEY (id);


--
-- Name: neighborhood neighborhood_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.neighborhood
    ADD CONSTRAINT neighborhood_pkey PRIMARY KEY (first_cage_id, second_cage_id);


--
-- Name: provider provider_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provider
    ADD CONSTRAINT provider_name_key UNIQUE (name);


--
-- Name: provider provider_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provider
    ADD CONSTRAINT provider_pkey PRIMARY KEY (id);


--
-- Name: species species_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.species
    ADD CONSTRAINT species_pkey PRIMARY KEY (id);


--
-- Name: supply supply_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supply
    ADD CONSTRAINT supply_pkey PRIMARY KEY (id);

--
-- Name: vet vet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vet
    ADD CONSTRAINT vet_pkey PRIMARY KEY (id);


--
-- Name: zoo zoo_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zoo
    ADD CONSTRAINT zoo_name_key UNIQUE (name);


--
-- Name: zoo zoo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zoo
    ADD CONSTRAINT zoo_pkey PRIMARY KEY (id);


--
-- Name: access access_access_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.access
    ADD CONSTRAINT access_access_employee_id_fkey FOREIGN KEY (access_employee_id) REFERENCES public.access_worker(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: access access_animal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.access
    ADD CONSTRAINT access_animal_id_fkey FOREIGN KEY (animal_id) REFERENCES public.animal(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: access_worker access_worker_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.access_worker
    ADD CONSTRAINT access_worker_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: animal animal_cage_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_cage_id_fkey FOREIGN KEY (cage_id) REFERENCES public.cage(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: animal animal_species_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_species_id_fkey FOREIGN KEY (species_id) REFERENCES public.species(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: builder_worker builder_worker_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.builder_worker
    ADD CONSTRAINT builder_worker_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: cleaner cleaner_access_worker_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cleaner
    ADD CONSTRAINT cleaner_access_worker_id_fkey FOREIGN KEY (access_worker_id) REFERENCES public.access_worker(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: compatibility compatibility_first_species_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compatibility
    ADD CONSTRAINT compatibility_first_species_id_fkey FOREIGN KEY (first_species_id) REFERENCES public.species(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: compatibility compatibility_second_species_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compatibility
    ADD CONSTRAINT compatibility_second_species_id_fkey FOREIGN KEY (second_species_id) REFERENCES public.species(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: exchange exchange_animal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exchange
    ADD CONSTRAINT exchange_animal_id_fkey FOREIGN KEY (animal_id) REFERENCES public.animal(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: exchange exchange_zoo_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exchange
    ADD CONSTRAINT exchange_zoo_id_fkey FOREIGN KEY (zoo_id) REFERENCES public.zoo(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: illness_on_medical_examination illness_on_medical_examination_illness_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illness_on_medical_examination
    ADD CONSTRAINT illness_on_medical_examination_illness_id_fkey FOREIGN KEY (illness_id) REFERENCES public.illness(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: illness_on_medical_examination illness_on_medical_examination_medical_examination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.illness_on_medical_examination
    ADD CONSTRAINT illness_on_medical_examination_medical_examination_id_fkey FOREIGN KEY (medical_examination_id) REFERENCES public.medical_examination(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: medical_examination medical_examination_animal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_examination
    ADD CONSTRAINT medical_examination_animal_id_fkey FOREIGN KEY (animal_id) REFERENCES public.animal(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: medical_examination medical_examination_vet_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_examination
    ADD CONSTRAINT medical_examination_vet_id_fkey FOREIGN KEY (vet_id) REFERENCES public.vet(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: neighborhood neighborhood_first_cage_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.neighborhood
    ADD CONSTRAINT neighborhood_first_cage_id_fkey FOREIGN KEY (first_cage_id) REFERENCES public.cage(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: neighborhood neighborhood_second_cage_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.neighborhood
    ADD CONSTRAINT neighborhood_second_cage_id_fkey FOREIGN KEY (second_cage_id) REFERENCES public.cage(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: supply supply_feed_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supply
    ADD CONSTRAINT supply_feed_id_fkey FOREIGN KEY (feed_id) REFERENCES public.feed(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: assortment supply_feed_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assortment
    ADD CONSTRAINT supply_feed_id_fkey FOREIGN KEY (feed_id) REFERENCES public.feed(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: supply supply_provider_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supply
    ADD CONSTRAINT supply_provider_id_fkey FOREIGN KEY (provider_id) REFERENCES public.provider(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: assortment supply_provider_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assortment
    ADD CONSTRAINT supply_provider_id_fkey FOREIGN KEY (provider_id) REFERENCES public.provider(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: vet vet_access_worker_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vet
    ADD CONSTRAINT vet_access_worker_id_fkey FOREIGN KEY (access_worker_id) REFERENCES public.access_worker(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--







