CREATE TABLE animal (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    sex CHAR(1),
    description TEXT,
    age_group_id BIGINT,
    castrated BOOLEAN,
    color INTEGER,
    aproximated_age INTEGER,
    created_at VARCHAR(255)
);