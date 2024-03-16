-- Database: base_dev

BEGIN;

CREATE TABLE IF NOT EXISTS public.itens
(
    id serial NOT NULL,
    nome text NOT NULL,
    valor text NOT NULL,
    qtd text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.roles
(
    id text NOT NULL,
    name text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.usuario
(
    id text NOT NULL,
    login text NOT NULL,
    password text NOT NULL,
    role text NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO ROLES(ID, NAME) VALUES('e937f4d2-2567-4a3f-87ea-92ab4ecb487d', 'ADMIN');
INSERT INTO ROLES(ID, NAME) VALUES('c9c7bfb4-d5d9-4945-841b-61e2417bf0fb',  'CLIENTE');
INSERT INTO ROLES(ID, NAME) VALUES('6891b13e-7d6d-4052-8b68-2e8f0328897a',  'USER');

END;
