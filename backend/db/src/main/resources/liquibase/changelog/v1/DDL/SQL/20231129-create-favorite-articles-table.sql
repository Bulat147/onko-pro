CREATE TABLE favorite_articles
(
    account_id uuid NOT NULL REFERENCES account (id),
    article_id uuid NOT NULL REFERENCES article (id),
    PRIMARY KEY (account_id, article_id)
)