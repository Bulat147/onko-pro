CREATE TABLE note
(
    id uuid PRIMARY KEY             DEFAULT uuid_generate_v4(),
    account_id uuid NOT NULL REFERENCES account (id),
    name varchar(32),
    treatment varchar(512),
    content varchar(512),
    created_date  timestamp without time zone NOT NULL DEFAULT now(),
    updated_date  timestamp without time zone NOT NULL DEFAULT now()
)