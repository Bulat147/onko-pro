CREATE TABLE article
(
    id            uuid PRIMARY KEY             DEFAULT uuid_generate_v4(),
    title varchar(64) NOT NULL,
    content varchar(2048) NOT NULL,
    position varchar(32) NOT NULL
)