DROP TABLE IF EXISTS holiday_entity CASCADE;
DROP TABLE IF EXISTS user_entity CASCADE;

CREATE TABLE user_entity(
                            id bigint not null primary key,
                            email VARCHAR(32),
                            login VARCHAR(32) UNIQUE,
                            name VARCHAR(32),
                            password VARCHAR(100),
                            surname VARCHAR(32),
                            notification_on BOOLEAN
);
create table holiday_entity
(
    id                bigint  not null primary key,
    accomodation_cost double precision,
    arrive_date       varchar,
    departure_date    varchar,
    travel_destination varchar,
    destination_address       varchar(255),
    user_id           integer
        constraint fkjgi8i8ygs2gd9s1ayk1ifs65w
            references user_entity
);

INSERT INTO public.user_entity VALUES (2, 't@g.com', 'test', 'Ewa', 'test', 'ewa', true);
INSERT INTO public.holiday_entity VALUES (2, 5000.0, '26.06.2024', '26.06.2024', 'Croatia', 'Croatia 2', 2);


