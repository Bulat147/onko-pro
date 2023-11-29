CREATE TABLE article_photos
(
    article_id uuid NOT NULL REFERENCES article (id),
    photo_id uuid NOT NULL REFERENCES photo (id),
    PRIMARY KEY (article_id, photo_id)
)