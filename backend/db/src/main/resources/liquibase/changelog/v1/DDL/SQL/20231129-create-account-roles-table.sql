CREATE TABLE account_roles
(
    account_id uuid NOT NULL REFERENCES account (id),
    account_role account_role NOT NULL,
    PRIMARY KEY (account_id, account_role)
)