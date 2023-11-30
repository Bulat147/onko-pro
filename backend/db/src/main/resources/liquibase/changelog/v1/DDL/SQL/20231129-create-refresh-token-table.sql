CREATE TABLE refresh_token
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name       uuid        NOT NULL,
    expire     timestamp   NOT NULL,
    account_id uuid UNIQUE NOT NULL REFERENCES account (id) ON DELETE CASCADE
)
