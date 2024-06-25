DROP TABLE IF EXISTS user_entity CASCADE;
CREATE TABLE user_entity(
    id INTEGER,
    email VARCHAR(32),
    login VARCHAR(32) UNIQUE,
    name VARCHAR(32),
    password VARCHAR(100),
    surname VARCHAR(32),
    notification_on BOOLEAN
);
INSERT INTO user_entity VALUES (1, 'ewus999@gmail.com', 'ewa', 'Ewa', '$2a$10$dPlNCylDEwJK6HVsnqeVU.XOi.PLUqbSv.rleMnhR.urO83uADsYi', 'Wieleba', true);