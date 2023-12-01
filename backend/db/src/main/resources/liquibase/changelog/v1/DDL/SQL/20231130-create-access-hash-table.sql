CREATE TABLE access_hash
(
    id            uuid PRIMARY KEY             DEFAULT uuid_generate_v4(),
    user_id       uuid NOT NULL REFERENCES account(id),
    expires_date  timestamp without time zone NOT NULL
)
