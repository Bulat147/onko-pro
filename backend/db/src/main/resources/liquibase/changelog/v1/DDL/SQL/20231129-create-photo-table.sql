CREATE TABLE photo
(
    id uuid PRIMARY KEY             DEFAULT uuid_generate_v4(),
    name varchar(64) NOT NULL UNIQUE
)