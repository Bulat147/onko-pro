CREATE TABLE note_tag
(
    id uuid PRIMARY KEY             DEFAULT uuid_generate_v4(),
    name varchar(64) NOT NULL,
    account_id uuid NOT NULL REFERENCES account (id)
)