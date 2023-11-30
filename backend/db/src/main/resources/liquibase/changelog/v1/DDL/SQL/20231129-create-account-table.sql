CREATE TABLE account
(
    id            uuid PRIMARY KEY             DEFAULT uuid_generate_v4(),
    email         varchar(255) UNIQUE NOT NULL,
    hash_password varchar(72)         NOT NULL, --BCrypt hash
    state         account_state       NOT NULL default 'NOT_CONFIRMED',
    first_name    varchar(32)         NOT NULL,
    last_name     varchar(32)         NOT NULL,
    gender        gender              NOT NULL,
    birth_date    timestamp,
    photo_id      uuid REFERENCES photo (id),
    created_date  timestamp without time zone NOT NULL DEFAULT now(),
    updated_date  timestamp without time zone NOT NULL DEFAULT now()
)
