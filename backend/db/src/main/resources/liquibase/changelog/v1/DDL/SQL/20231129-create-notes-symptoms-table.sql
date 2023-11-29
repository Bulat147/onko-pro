CREATE TABLE notes_symptoms
(
    note_id uuid NOT NULL REFERENCES note (id),
    symptom_id uuid NOT NULL REFERENCES symptom (id),
    PRIMARY KEY (note_id, symptom_id)
)