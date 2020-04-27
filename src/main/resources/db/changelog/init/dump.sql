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


--
-- Name: actor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.actor (
    id integer NOT NULL,
    num integer
);


ALTER TABLE public.actor OWNER TO postgres;

--
-- Name: actor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.actor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.actor_id_seq OWNER TO postgres;

--
-- Name: actor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.actor_id_seq OWNED BY public.actor.id;


--
-- Name: animal; Type: TABLE; Schema: public; Owner: postgres
--

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
-- Name: test; Type: TABLE; Schema: public; Owner: Olya
--

CREATE TABLE public.test (
    id integer NOT NULL,
    surname text NOT NULL,
    monthly_salary integer NOT NULL,
    CONSTRAINT test_monthly_salary_check CHECK ((monthly_salary > 0))
);


ALTER TABLE public.test OWNER TO "Olya";

--
-- Name: test_id_seq; Type: SEQUENCE; Schema: public; Owner: Olya
--

CREATE SEQUENCE public.test_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.test_id_seq OWNER TO "Olya";

--
-- Name: test_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Olya
--

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;


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
-- Name: actor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actor ALTER COLUMN id SET DEFAULT nextval('public.actor_id_seq'::regclass);


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
-- Name: test id; Type: DEFAULT; Schema: public; Owner: Olya
--

ALTER TABLE ONLY public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);


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

COPY public.access (animal_id, access_employee_id, access_start_date) FROM stdin;
86	6	2009-04-12
35	52	2019-03-17
77	50	2012-12-09
81	29	2014-09-05
46	27	2019-08-24
97	25	2008-10-05
27	33	2015-11-09
44	3	2013-11-25
27	11	2013-09-05
6	1	2014-11-26
83	9	2019-03-20
76	13	2008-11-03
54	22	2008-09-26
34	18	2010-08-20
89	24	2009-06-04
68	44	2005-12-06
95	57	2005-09-05
91	33	2011-07-31
45	50	2013-09-04
74	26	2009-06-14
96	26	2016-03-02
5	57	2012-03-07
26	1	2019-08-27
32	33	2004-11-27
25	52	2010-03-20
67	31	2018-09-24
99	55	2016-04-29
2	41	2013-09-30
73	26	2011-03-25
10	22	2006-12-30
83	6	2007-01-15
73	54	2008-05-22
48	56	2015-12-21
51	50	2014-04-25
91	17	2008-11-21
3	51	2014-09-04
12	15	2009-09-27
68	46	2005-07-13
58	20	2014-09-16
34	21	2018-03-15
67	48	2014-07-13
91	10	2011-09-03
98	10	2005-08-21
51	13	2012-11-04
93	4	2006-01-22
13	8	2019-05-06
22	28	2015-03-08
21	11	2016-09-23
32	52	2015-10-01
36	11	2013-02-13
36	24	2009-08-16
68	3	2018-11-01
83	57	2012-02-05
3	59	2017-07-07
2	19	2018-05-17
83	58	2008-09-24
9	2	2008-02-29
22	10	2018-11-30
84	4	2005-02-13
5	51	2017-10-03
49	23	2018-07-04
63	57	2010-04-22
32	39	2009-08-21
55	21	2010-04-11
69	59	2009-11-20
8	55	2011-10-05
46	39	2017-04-14
67	15	2017-12-03
88	41	2008-01-16
37	59	2016-01-05
21	56	2013-09-16
46	29	2017-10-04
63	19	2017-12-24
22	26	2008-03-10
67	32	2018-12-01
17	16	2017-12-29
49	6	2007-01-03
17	30	2018-08-14
83	33	2016-03-09
2	45	2018-11-14
35	31	2007-05-29
86	47	2005-01-27
32	58	2006-06-22
70	42	2007-12-20
2	6	2005-05-22
49	15	2019-09-07
91	1	2019-01-12
12	25	2007-02-14
14	58	2006-10-22
85	28	2019-06-06
36	20	2015-08-10
62	46	2017-01-05
76	27	2018-03-26
93	46	2018-08-01
48	53	2007-11-02
5	45	2017-08-24
98	46	2018-09-15
61	49	2018-01-04
12	37	2019-04-26
69	19	2006-11-26
\.


--
-- Data for Name: access_worker; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.access_worker (id, employee_id) FROM stdin;
1	1
2	2
3	3
4	4
5	5
6	6
7	7
8	8
9	9
10	10
11	11
12	12
13	13
14	14
15	15
16	16
17	17
18	18
19	19
20	20
21	21
22	22
23	23
24	24
25	25
26	26
27	27
28	28
29	29
30	30
31	31
32	32
33	33
34	34
35	35
36	36
37	37
38	38
39	39
40	40
41	41
42	42
43	43
44	44
45	45
46	46
47	47
48	48
49	49
50	50
51	51
52	52
53	53
54	54
55	55
56	56
57	57
58	58
59	59
60	60
\.


--
-- Data for Name: actor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.actor (id, num) FROM stdin;
\.


--
-- Data for Name: animal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.animal (id, cage_id, species_id, date_of_birth, gender, physical_state, hospital, reciept_date, number_of_offspring) FROM stdin;
1	55	9	2010-09-02	м	f	f	2010-10-05	7
2	56	3	2019-02-18	ж	f	f	2018-07-06	3
3	80	2	2016-06-14	ж	t	f	2011-11-21	8
4	84	7	2014-08-30	м	f	t	2018-01-03	1
5	4	6	2016-08-16	ж	f	t	2012-04-14	7
6	9	4	2018-08-24	м	t	t	2007-06-07	1
7	25	2	2019-05-26	м	f	f	2016-12-02	5
8	45	3	2008-02-29	м	f	t	2013-11-21	0
9	7	4	2004-12-22	ж	t	f	2009-07-07	9
10	7	4	2016-12-30	м	t	f	2014-12-08	5
11	86	5	2006-11-10	ж	f	f	2008-07-06	4
12	77	6	2013-09-23	ж	f	f	2019-08-19	6
13	56	8	2016-01-17	м	t	f	2010-11-14	0
14	67	5	2013-08-18	ж	f	f	2012-09-13	6
15	93	7	2017-12-02	м	f	f	2009-04-19	2
16	91	4	2015-05-10	м	f	f	2010-01-10	1
17	64	8	2019-09-03	м	f	t	2010-11-14	5
18	3	1	2016-09-13	ж	f	t	2019-09-04	6
19	36	9	2010-05-23	м	f	f	2010-04-10	8
20	11	1	2017-01-08	ж	f	f	2013-10-11	3
21	75	2	2012-02-05	ж	t	f	2016-11-25	5
22	58	4	2006-01-27	м	f	t	2009-05-07	8
23	45	1	2008-11-21	ж	f	t	2006-10-23	5
24	46	5	2015-06-12	м	f	t	2014-07-17	4
25	7	6	2019-08-07	м	f	f	2008-02-24	1
26	27	2	2014-03-13	м	f	f	2005-11-12	5
27	30	1	2019-08-21	ж	f	f	2019-09-19	7
28	1	6	2014-11-25	м	t	f	2008-11-20	9
29	32	8	2014-07-27	м	f	f	2012-05-23	3
30	63	7	2015-10-12	м	f	f	2007-10-20	3
31	84	8	2009-07-27	ж	t	f	2019-08-31	3
32	35	3	2008-02-28	ж	f	f	2016-04-10	1
33	38	2	2010-03-09	м	f	f	2014-10-29	9
34	33	3	2011-04-25	ж	f	t	2008-05-27	6
35	14	2	2008-02-28	м	f	f	2011-03-16	1
36	98	3	2009-12-25	м	f	t	2014-05-01	6
37	4	1	2018-09-23	м	f	f	2008-12-28	8
38	31	7	2019-08-13	ж	f	f	2015-04-15	4
39	26	9	2017-06-07	м	f	t	2011-02-20	9
40	13	8	2004-12-05	ж	f	f	2013-02-25	9
41	22	1	2006-12-03	ж	t	f	2006-02-02	3
42	36	3	2011-06-29	м	f	f	2017-12-12	0
43	65	2	2017-12-28	ж	f	f	2008-09-24	8
44	3	4	2008-11-27	м	f	t	2004-11-24	5
45	97	6	2007-07-27	м	f	f	2009-05-02	4
46	54	8	2014-11-27	м	f	t	2012-01-26	4
47	60	2	2019-06-24	ж	f	t	2014-01-20	8
48	47	7	2014-08-03	м	f	f	2012-07-13	5
49	24	6	2008-04-05	ж	f	t	2015-05-10	0
50	5	5	2006-07-03	ж	f	f	2006-04-19	2
51	49	5	2015-02-18	м	f	f	2012-04-18	5
52	56	2	2011-10-09	ж	f	f	2008-10-20	0
53	3	7	2017-10-26	м	f	f	2013-06-11	5
54	60	9	2018-02-04	м	f	f	2008-08-10	5
55	24	5	2016-01-06	м	t	f	2011-01-10	8
56	33	4	2005-02-24	ж	f	f	2013-03-01	2
57	13	2	2009-06-03	м	t	f	2019-02-10	7
58	90	1	2014-12-27	м	f	f	2018-12-19	2
59	61	8	2018-07-30	м	f	f	2007-06-15	1
60	48	8	2010-04-09	ж	f	f	2012-05-04	3
61	93	2	2015-03-25	ж	f	t	2006-10-01	4
62	58	9	2014-01-23	м	t	t	2007-10-19	6
63	48	8	2007-10-27	ж	t	f	2006-03-11	3
64	33	2	2006-11-13	м	f	f	2012-12-10	5
65	94	8	2006-01-03	м	f	f	2011-11-15	2
66	53	5	2004-12-23	м	f	f	2014-07-06	5
67	7	9	2015-01-24	ж	t	t	2014-03-05	4
68	8	1	2008-09-17	м	f	f	2018-06-06	3
69	60	5	2018-06-23	ж	f	f	2013-04-20	5
70	78	2	2018-03-22	ж	t	t	2017-03-26	8
71	77	3	2007-07-02	м	f	t	2007-06-07	5
72	34	7	2009-06-02	ж	f	f	2008-04-17	0
73	32	5	2008-04-04	м	f	f	2015-04-25	3
74	20	9	2016-10-26	м	f	f	2005-11-12	2
75	7	1	2010-06-07	м	f	t	2017-08-23	5
76	40	7	2011-04-28	ж	f	f	2005-08-14	5
77	7	3	2005-11-07	м	f	f	2017-06-01	3
78	52	3	2012-06-01	ж	f	t	2013-10-28	7
79	2	2	2012-08-17	ж	t	f	2016-09-03	0
80	64	9	2017-11-17	м	f	f	2011-03-11	8
81	22	8	2017-06-27	ж	f	f	2014-05-09	2
82	60	6	2013-07-18	м	f	f	2012-07-29	7
83	79	7	2018-10-05	м	t	t	2015-11-28	3
84	68	1	2019-02-15	м	f	f	2014-10-25	7
85	39	5	2019-05-21	ж	f	f	2008-02-13	9
86	72	2	2018-04-23	м	f	t	2005-08-13	6
87	43	9	2007-05-14	м	f	t	2012-03-27	0
88	20	7	2011-06-13	м	f	f	2005-07-29	1
89	73	5	2012-09-05	ж	f	f	2014-01-03	6
90	78	1	2007-11-11	ж	t	f	2008-04-20	8
91	12	2	2016-07-10	м	f	f	2017-07-21	4
92	46	4	2016-10-27	ж	f	t	2008-05-07	1
93	69	3	2009-06-12	м	t	f	2009-07-18	2
94	17	7	2010-02-15	м	f	t	2005-01-12	5
95	17	4	2015-06-30	м	f	f	2005-01-10	3
96	30	2	2014-07-03	ж	f	t	2014-02-03	5
97	90	5	2014-03-11	м	f	f	2004-12-17	0
98	38	7	2012-04-04	ж	f	f	2015-10-15	4
99	10	4	2006-11-06	ж	f	f	2016-08-21	1
100	46	8	2018-02-17	м	f	f	2007-07-27	7
\.


--
-- Data for Name: assortment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.assortment (provider_id, feed_id) FROM stdin;
1	1
1	2
1	3
1	4
1	5
2	3
3	2
3	3
3	4
3	5
3	6
3	7
4	7
5	5
5	6
5	7
5	8
6	5
6	6
6	7
6	8
7	5
8	7
8	8
8	9
9	9
10	8
10	9
10	10
11	8
11	9
11	10
\.


--
-- Data for Name: builder_worker; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.builder_worker (id, employee_id, building_for_repair) FROM stdin;
1	61	2
2	62	2
3	63	1
4	64	5
5	65	5
6	66	3
7	67	5
8	68	4
9	69	4
10	70	2
11	71	1
12	72	1
13	73	4
14	74	3
15	75	1
16	76	2
17	77	1
18	78	1
19	79	1
20	80	1
\.


--
-- Data for Name: cage; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cage (id, inmate) FROM stdin;
1	f
2	f
3	f
4	f
5	f
6	t
7	f
8	f
9	f
10	t
11	f
12	f
13	f
14	f
15	t
16	t
17	t
18	f
19	f
20	f
21	f
22	f
23	f
24	f
25	t
26	t
27	f
28	t
29	f
30	f
31	f
32	f
33	f
34	t
35	f
36	f
37	f
38	f
39	f
40	t
41	t
42	t
43	f
44	t
45	f
46	t
47	t
48	f
49	f
50	f
51	f
52	t
53	f
54	f
55	f
56	f
57	f
58	f
59	f
60	f
61	f
62	f
63	f
64	t
65	f
66	f
67	t
68	t
69	f
70	f
71	f
72	f
73	t
74	f
75	t
76	t
77	t
78	f
79	f
80	f
81	f
82	f
83	f
84	f
85	t
86	t
87	t
88	t
89	f
90	t
91	t
92	t
93	f
94	f
95	t
96	f
97	t
98	f
99	t
\.


--
-- Data for Name: cleaner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cleaner (id, access_worker_id, pantry_number) FROM stdin;
1	21	26
2	22	28
3	23	18
4	24	27
5	25	18
6	26	24
7	27	15
8	28	23
9	29	24
10	30	23
11	31	15
12	32	26
13	33	16
14	34	15
15	35	24
16	36	22
17	37	18
18	38	24
19	39	15
20	40	19
\.


--
-- Data for Name: compatibility; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.compatibility (first_species_id, second_species_id) FROM stdin;
1	1
2	2
3	3
4	4
5	5
6	6
7	7
8	8
9	9
10	10
1	4
1	5
4	5
1	6
1	8
4	6
4	8
5	6
5	8
6	8
2	3
2	9
2	10
3	9
3	10
9	10
7	8
7	1
\.

--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, name, surname, work_start_date, gender, monthly_salary) FROM stdin;
1	Трофимов	Виталий	2016-03-24	м	26439
2	Антонов	Богдан	2018-12-21	м	26645
3	Белоусов	Адольф	2013-12-06	м	25736
4	Ковалёв	Антон	2011-09-16	м	25981
5	Тихонов	Тарас	2014-04-01	м	29079
6	Белов	Эльдар	2014-01-30	м	25668
7	Родионов	Матвей	2017-12-30	м	23605
8	Поляков	Родион	2005-03-22	м	26884
9	Шаров	Тимофей	2012-07-21	м	18589
10	Терентьев	Николай	2018-01-06	м	24131
11	Калашников	Андрей	2005-12-11	м	17035
12	Калинин	Георгий	2017-08-24	м	25192
13	Голубев	Касьян	2006-10-31	м	28432
14	Герасимов	Николай	2016-12-04	м	20274
15	Ефремов	Корней	2009-09-05	м	17226
16	Дементьев	Михаил	2008-03-27	м	29622
17	Лукин	Авраам	2011-07-14	м	29070
18	Мясников	Любомир	2009-05-04	м	16319
19	Воронов	Oрест	2016-01-21	м	29297
20	Гуляев	Май	2015-07-15	м	18666
21	Филатов	Клемент	2007-03-25	м	17796
22	Кудрявцев	Леонид	2012-11-18	м	24302
23	Шарапов	Исак	2006-09-16	м	23886
24	Овчинников	Денис	2019-08-18	м	29562
25	Якушев	Адам	2005-10-26	м	27249
26	Селиверстов	Анатолий	2005-06-27	м	29199
27	Кабанов	Казимир	2005-03-31	м	21037
28	Борисов	Зиновий	2011-10-20	м	28417
29	Мамонтов	Валентин	2008-07-13	м	19595
30	Фомичёв	Ефрем	2007-05-16	м	23484
31	Белоусов	Виктор	2004-12-19	м	18781
32	Ширяев	Назарий	2007-02-11	м	26791
33	Пономарёв	Адам	2006-09-26	м	15170
34	Никитин	Аверьян	2009-02-17	м	27800
35	Носов	Богдан	2009-05-22	м	17721
36	Елисеев	Ибрагил	2015-12-07	м	26828
37	Пестов	Эрнест	2006-12-02	м	17236
38	Григорьев	Эльдар	2014-06-26	м	17871
39	Трофимов	Бенедикт	2007-08-05	м	26601
40	Потапов	Аким	2007-03-29	м	29647
41	Лобанов	Александр	2009-08-28	м	26308
42	Горшков	Иннокентий	2014-01-27	м	17040
43	Тетерин	Рудольф	2007-06-30	м	24575
44	Веселов	Нинель	2018-06-03	м	16672
45	Мухин	Алан	2011-10-14	м	26728
46	Жданов	Станислав	2006-01-27	м	29196
47	Носков	Давид	2010-12-18	м	18704
48	Авдеев	Людвиг	2016-11-28	м	16351
49	Богданов	Артем	2017-01-06	м	23576
50	Блохин	Лев	2011-09-23	м	29784
51	Бобылёва	Фелиция	2008-03-08	ж	19038
52	Белозёрова	Юлиана	2019-07-28	ж	16969
53	Павлова	Полина	2007-06-21	ж	28047
54	Коновалова	Юфеза	2011-03-15	ж	24545
55	Комарова	Ралина	2007-11-23	ж	27147
56	Шестакова	Божена	2006-10-20	ж	29670
57	Самойлова	Дарья	2004-12-25	ж	23462
58	Лукина	Эвелина	2008-12-04	ж	28009
59	Иванова	Алёна	2008-03-29	ж	17637
60	Ильина	Зоя	2006-05-09	ж	19100
61	Дроздова	Борислава	2015-07-08	ж	26697
62	Афанасьева	Таисия	2019-03-14	ж	17258
63	Никонова	Ариадна	2018-10-20	ж	27752
64	Петухова	Ярослава	2018-06-17	ж	22499
65	Сорокина	Веста	2013-01-29	ж	19122
66	Алексеева	Дарина	2010-11-30	ж	15850
67	Виноградова	Эмилия	2012-04-25	ж	19160
68	Гущина	Романа	2009-10-02	ж	15397
69	Лебедева	Ивона	2006-08-13	ж	25921
70	Гусева	Милана	2008-04-14	ж	20143
71	Кабанова	Зоя	2013-06-24	ж	28019
72	Калинина	Пелагея	2018-01-31	ж	18106
73	Богданова	Аделина	2013-07-08	ж	15600
74	Федосеева	Инна	2012-08-22	ж	26932
75	Рогова	Тамара	2012-04-19	ж	18400
76	Горшкова	Эвелина	2017-04-03	ж	15557
77	Лихачёва	Габи	2010-04-06	ж	29427
78	Яковлева	Харитина	2009-01-14	ж	15603
79	Воробьёва	Андриана	2014-01-27	ж	25785
80	Белозёрова	Элиза	2015-10-19	ж	17126
81	Дроздова	Лиза	2006-07-12	ж	17818
82	Тимофеева	Аделия	2005-10-29	ж	22501
83	Меркушева	Хана	2008-09-28	ж	16070
84	Фомичёва	Розалина	2006-07-18	ж	22739
85	Кулагина	Софья	2019-03-28	ж	28328
86	Григорьева	Регина	2006-09-18	ж	27620
87	Комиссарова	Лайма	2010-09-08	ж	21811
88	Некрасова	Аксинья	2007-04-04	ж	16671
89	Наумова	Радослава	2010-03-16	ж	22286
90	Лаврентьева	Есения	2008-04-19	ж	17596
91	Евсеева	Сабина	2005-07-18	ж	26569
92	Гришина	Ясмина	2007-02-17	ж	23904
93	Ефимова	Селена	2013-03-13	ж	28877
94	Горшкова	Нонна	2016-11-11	ж	27598
95	Ефимова	Зоряна	2005-01-31	ж	16607
96	Архипова	Мериса	2016-05-07	ж	22474
97	Ильина	Гелла	2018-05-06	ж	18772
98	Тетерина	Ираида	2011-11-22	ж	22312
99	Гущина	Есения	2010-09-11	ж	19007
100	Богданова	Эльмира	2014-12-20	ж	19162
\.


--
-- Data for Name: exchange; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exchange (zoo_id, animal_id, side) FROM stdin;
3	36	t
6	6	f
9	17	f
4	71	t
1	62	f
9	97	f
7	16	f
1	26	f
5	71	t
6	57	f
2	62	f
8	5	t
9	33	f
3	12	f
4	87	f
5	27	f
4	51	f
8	75	f
1	15	f
7	71	f
4	62	f
8	79	t
7	7	f
9	70	f
2	20	t
8	64	t
2	7	f
3	81	f
3	96	f
2	32	f
2	15	f
3	62	f
4	35	t
9	71	f
3	4	t
2	90	t
1	19	f
1	85	t
4	17	f
4	24	f
5	48	f
5	30	t
8	24	f
2	50	t
8	94	f
9	39	t
4	80	f
7	26	f
3	59	f
3	32	t
\.


--
-- Data for Name: feed; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.feed (id, name, type) FROM stdin;
1	фрукты	растительный
2	овощи	растительный
3	зерно	растительный
4	сено	растительный
5	мыши	живой
6	птицы	живой
7	говядина	мясо
8	свинина	мясо
9	смесь	комбикорм
10	смеси	комбикорм
\.


--
-- Data for Name: illness; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.illness (id, name, graft) FROM stdin;
1	бешенство	прививка от бешенства
2	лептаспириоз	антитела
3	гастроэнтерит	не требуется
4	бруцеллёз	антибиотики
5	лептаспироз	антибиотики
6	брадзот	антитела
7	чума	не требуется
8	токсоплазмоз	антибиотики
9	энтерит	прививка от энтерита
10	гетерохромия	не требуется
\.


--
-- Data for Name: illness_on_medical_examination; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.illness_on_medical_examination (illness_id, medical_examination_id) FROM stdin;
2	79
1	13
8	58
3	53
7	52
9	54
7	78
8	47
1	50
8	79
7	41
1	62
3	90
4	84
3	69
6	51
8	20
7	19
8	98
3	14
4	64
2	11
3	80
7	74
5	86
1	87
9	23
7	42
4	75
9	39
3	71
3	72
5	17
3	12
3	32
5	51
4	88
5	55
3	57
6	23
9	26
7	72
5	23
3	77
8	72
5	70
2	92
8	51
7	28
8	88
9	6
7	86
7	39
2	62
5	82
6	8
8	1
8	74
4	22
4	92
7	24
2	69
6	82
8	57
9	16
3	9
1	66
6	52
4	62
5	58
2	83
3	97
6	96
4	32
8	54
5	45
3	94
3	23
8	65
8	56
5	97
5	53
1	78
3	87
2	55
1	76
6	5
2	37
6	45
4	74
2	46
5	42
4	90
8	34
5	25
5	68
1	16
5	83
4	50
4	98
\.


--
-- Data for Name: medical_examination; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medical_examination (id, animal_id, vet_id, weight, height) FROM stdin;
1	24	6	59	234
2	20	2	57	250
3	3	13	89	256
4	37	2	26	298
5	3	9	97	110
6	33	1	6	64
7	74	2	94	161
8	10	5	9	215
9	80	2	60	59
10	31	8	25	99
11	93	2	78	64
12	20	3	75	103
13	85	13	98	173
14	63	18	33	264
15	76	6	81	133
16	78	4	55	251
17	81	15	86	277
18	73	3	59	264
19	22	1	82	278
20	86	11	22	177
21	22	1	91	69
22	53	4	74	297
23	97	5	77	56
24	85	9	58	196
25	75	9	19	161
26	85	6	68	192
27	80	8	30	103
28	36	5	35	221
29	1	10	14	237
30	54	2	45	87
31	76	11	73	135
32	64	19	93	171
33	6	1	88	267
34	11	17	60	184
35	65	4	31	171
36	27	18	23	130
37	17	16	55	97
38	17	8	67	92
39	36	3	55	155
40	16	8	98	133
41	84	19	40	255
42	48	9	26	165
43	20	17	24	296
44	82	14	59	140
45	74	13	74	262
46	14	11	61	133
47	29	18	40	228
48	17	2	76	250
49	35	11	14	296
50	27	14	6	136
51	52	14	43	240
52	78	10	22	282
53	65	2	78	74
54	3	1	78	243
55	26	8	57	102
56	34	18	86	169
57	82	17	49	203
58	46	5	94	70
59	35	12	96	75
60	23	15	42	158
61	39	2	86	287
62	99	7	10	228
63	15	16	97	281
64	78	9	25	229
65	97	19	23	85
66	73	4	84	285
67	29	6	2	191
68	56	13	78	56
69	59	17	68	269
70	26	13	66	213
71	41	1	4	235
72	84	19	99	107
73	20	4	19	179
74	82	16	57	54
75	22	6	59	86
76	3	10	44	295
77	28	3	12	270
78	6	5	10	115
79	15	16	69	277
80	54	7	7	149
81	43	17	8	215
82	74	1	23	88
83	21	10	94	216
84	6	2	54	288
85	57	8	91	171
86	94	14	90	227
87	72	14	26	86
88	78	18	98	287
89	29	8	86	179
90	47	2	57	90
91	88	11	42	265
92	4	2	78	172
93	54	9	81	151
94	86	15	87	203
95	74	16	76	208
96	77	16	25	209
97	81	5	82	246
98	10	12	67	277
99	17	3	16	195
100	1	16	17	137
\.


--
-- Data for Name: neighborhood; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.neighborhood (first_cage_id, second_cage_id) FROM stdin;
90	91
28	67
70	9
55	44
13	46
50	6
55	89
50	8
4	37
95	89
22	9
96	32
61	63
74	35
64	43
29	53
75	74
17	38
86	91
78	67
31	61
81	32
60	68
97	29
2	46
39	63
61	4
6	37
85	39
45	50
55	72
72	24
79	39
64	33
46	35
39	94
10	82
31	77
41	1
49	39
85	34
63	85
80	39
44	5
91	51
35	57
30	24
17	30
60	87
57	77
69	55
98	12
77	72
93	87
90	20
60	63
69	91
13	92
21	53
54	63
93	79
55	31
52	65
69	53
53	64
50	80
68	76
28	29
91	1
41	74
19	26
58	37
76	10
8	66
79	79
20	55
16	87
49	69
57	85
40	1
87	93
82	1
21	22
27	10
95	97
87	28
70	64
25	70
38	23
26	7
13	13
51	85
89	92
84	14
36	82
32	17
64	17
65	18
30	1
59	17
\.


--
-- Data for Name: provider; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.provider (id, name) FROM stdin;
1	ZooMarket
2	Зоолавка
3	Зоомир
4	Зоомагазин
5	Зоомаркет
6	Зоосалон
7	Зоосервис
8	Зоосказка
9	Зооуголок
10	Зооквартал
11	Зоопарк
\.


--
-- Data for Name: species; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.species (id, name, type, need_warm_place, age_for_childbirth) FROM stdin;
1	лошадь	травоядное	f	3
2	тигр	хищник	f	2
3	лев	хищник	t	3
4	олень	травоядное	f	3
5	сова	хищник	f	1
6	жираф	травоядное	t	4
7	носорог	травоядное	f	2
8	слон	травоядное	f	3
9	гиена	хищник	f	3
10	медведь	хищник	f	2
\.


--
-- Data for Name: supply; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supply (id, provider_id, feed_id, supply_date, feed_amount, price) FROM stdin;
1	1	1	2009-11-06	60	64
2	1	3	2014-05-26	35	28
3	1	3	2007-11-08	42	78
4	1	1	2005-03-15	18	48
5	1	3	2012-08-14	91	92
6	1	4	2014-03-18	10	57
7	1	4	2005-10-28	16	38
8	1	4	2014-02-24	87	86
9	1	1	2011-11-04	62	43
10	1	1	2008-08-10	24	96
11	1	2	2007-04-06	96	81
12	1	1	2013-11-17	47	60
13	1	2	2019-07-25	71	74
14	1	2	2019-08-12	25	57
15	1	3	2013-07-09	25	83
16	1	3	2007-02-23	50	46
17	1	3	2015-08-20	28	96
18	1	2	2013-08-22	91	36
19	1	4	2007-01-11	29	69
20	1	3	2010-07-11	39	93
21	3	2	2009-05-26	34	82
22	3	4	2005-06-27	50	8
23	3	3	2007-06-10	6	44
24	3	2	2008-02-11	52	48
25	3	3	2016-04-27	63	40
26	3	2	2007-09-23	13	90
27	3	2	2008-07-29	70	62
28	3	6	2010-09-22	52	31
29	3	2	2007-04-17	67	18
30	3	5	2007-10-02	5	67
31	3	3	2010-10-12	82	90
32	3	2	2019-06-14	80	79
33	3	5	2012-11-29	46	30
34	3	6	2010-08-22	91	80
35	3	5	2013-07-23	91	44
36	5	5	2005-07-22	40	73
37	6	6	2017-04-25	7	82
38	5	6	2007-09-15	97	85
39	6	6	2017-11-06	54	45
40	6	5	2011-07-28	64	84
41	6	7	2018-11-03	46	71
42	6	6	2006-02-12	27	45
43	6	5	2008-06-28	48	99
44	5	6	2018-06-23	82	67
45	6	6	2012-06-09	27	31
46	6	5	2007-01-05	97	49
47	5	7	2015-02-10	76	56
48	6	7	2008-03-01	70	49
49	6	7	2007-06-02	85	64
50	6	5	2004-12-08	6	98
51	6	6	2010-11-30	26	82
52	5	7	2012-06-14	79	92
53	5	5	2008-09-15	78	8
54	5	6	2016-07-30	96	44
55	5	5	2019-02-14	88	84
56	5	5	2012-07-13	40	5
57	5	5	2017-05-19	28	84
58	5	5	2010-10-14	95	67
59	5	7	2013-02-23	96	88
60	5	7	2019-05-27	33	87
61	8	8	2012-06-14	66	18
62	8	7	2015-01-14	29	19
63	8	8	2013-04-15	36	48
64	8	7	2013-03-16	39	27
65	8	8	2016-07-05	46	22
66	8	8	2005-04-24	10	30
67	8	8	2008-05-02	94	70
68	8	7	2010-12-20	44	16
69	8	8	2012-07-21	16	77
70	8	7	2007-02-06	8	12
71	8	7	2009-02-17	23	71
72	8	8	2017-10-16	26	88
73	8	7	2007-01-19	17	18
74	8	8	2007-07-31	98	27
75	8	8	2008-08-01	8	88
76	8	8	2009-07-11	43	10
77	8	8	2018-12-20	21	57
78	8	7	2012-04-13	63	93
79	8	8	2018-10-18	97	69
80	8	8	2012-10-18	19	47
81	10	9	2019-04-04	63	50
82	11	8	2016-03-25	15	53
83	10	8	2007-04-13	39	68
84	11	8	2005-05-11	84	17
85	11	9	2015-05-25	39	18
86	10	9	2018-03-01	92	59
87	10	8	2018-09-27	63	17
88	10	9	2006-04-11	97	9
89	10	8	2010-12-14	46	89
90	11	8	2014-06-20	45	71
91	10	8	2007-09-06	90	16
92	11	8	2007-05-03	18	48
93	10	8	2007-06-09	7	5
94	10	9	2008-01-28	70	58
95	11	8	2007-09-26	49	69
96	11	8	2011-12-27	8	64
97	10	9	2018-12-25	36	17
98	11	9	2011-02-04	85	11
99	10	8	2005-07-16	95	38
100	10	9	2019-08-15	53	81
\.


--
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: Olya
--

COPY public.test (id, surname, monthly_salary) FROM stdin;
1	test	2000
\.


--
-- Data for Name: vet; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vet (id, access_worker_id, laboratory_number) FROM stdin;
1	9	28
2	4	21
3	14	29
4	1	19
5	12	29
6	13	20
7	6	24
8	10	15
9	5	23
10	16	19
11	11	23
12	20	26
13	8	28
14	2	15
15	15	18
16	19	27
17	7	23
18	3	17
19	17	21
20	18	19
\.


--
-- Data for Name: zoo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.zoo (id, name) FROM stdin;
1	Лимпопо
2	Швейцария
3	Нептун
4	Додо
5	Воробьи
6	Сафари
7	Тайган
8	Планета
9	Ручей
10	Приамурский
\.


--
-- Name: access_worker_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.access_worker_id_seq', 60, true);


--
-- Name: actor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.actor_id_seq', 1, false);


--
-- Name: animal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.animal_id_seq', 100, true);


--
-- Name: builder_worker_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.builder_worker_id_seq', 20, true);


--
-- Name: cage_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cage_id_seq', 99, true);


--
-- Name: cleaner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cleaner_id_seq', 20, true);


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_id_seq', 100, true);


--
-- Name: feed_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.feed_id_seq', 10, true);


--
-- Name: illness_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.illness_id_seq', 10, true);


--
-- Name: medical_examination_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medical_examination_id_seq', 100, true);


--
-- Name: provider_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.provider_id_seq', 11, true);


--
-- Name: species_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.species_id_seq', 10, true);


--
-- Name: supply_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supply_id_seq', 100, true);


--
-- Name: test_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Olya
--

SELECT pg_catalog.setval('public.test_id_seq', 1, false);


--
-- Name: vet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vet_id_seq', 20, true);


--
-- Name: zoo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.zoo_id_seq', 10, true);


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
-- Name: actor actor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actor
    ADD CONSTRAINT actor_pkey PRIMARY KEY (id);


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
-- Name: test test_pkey; Type: CONSTRAINT; Schema: public; Owner: Olya
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


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

