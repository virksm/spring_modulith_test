CREATE TABLE field
(
    id   UUID PRIMARY KEY,
    name TEXT
);

CREATE TABLE satellite_image
(
    id       UUID PRIMARY KEY,
    field_id UUID REFERENCES field (id) ON DELETE CASCADE
);

CREATE TABLE jpa_event_publication
(
    id               UUID PRIMARY KEY,
    publication_date TIMESTAMP,
    listener_id      TEXT,
    serialized_event TEXT,
    event_type       TEXT,
    completion_date  TIMESTAMP
)