CREATE TABLE notes_tags
(
    note_id uuid NOT NULL REFERENCES note (id),
    tag_id uuid NOT NULL REFERENCES note_tag (id) ON DELETE CASCADE,
    PRIMARY KEY (note_id, tag_id)
)