CREATE TABLE notes_tags
(
    note_id uuid NOT NULL REFERENCES note (id),
    tag_id uuid NOT NULL REFERENCES note_tag (id),
    PRIMARY KEY (note_id, tag_id)
)