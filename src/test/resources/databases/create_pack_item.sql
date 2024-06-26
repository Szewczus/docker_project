DROP TABLE IF EXISTS pack_item_entity CASCADE;
DROP TABLE IF EXISTS item_cost_entity CASCADE;
DROP TABLE IF EXISTS holiday_entity CASCADE;
DROP TABLE IF EXISTS user_entity CASCADE;
CREATE TABLE user_entity(
                            id INTEGER primary key ,
                            email VARCHAR(32),
                            login VARCHAR(32) UNIQUE,
                            name VARCHAR(32),
                            password VARCHAR(100),
                            surname VARCHAR(32),
                            notification_on BOOLEAN
);
create table holiday_entity
(
    id                integer primary key,
    accomodation_cost double precision,
    arrive_date       varchar,
    departure_date    varchar,
    travel_destination varchar,
    destination_address       varchar(255),
    user_id           bigint
        constraint fkjgi8i8ygs2gd9s1ayk1ifs65w
            references user_entity
);


create table item_cost_entity
(
    id         bigint not null
        primary key,
    cost       double precision,
    item       varchar(255),
    holiday_id bigint
        constraint fkb75cobc94nhgpcfmgopspppor
            references holiday_entity
);

create table pack_item_entity
(
    id          bigint not null
        primary key,
    description varchar(255),
    item        varchar(255),
    item_count  integer,
    holiday_id  bigint
        constraint fkjmj1rcd5vkaxuee1c58n5u0qv
            references holiday_entity
);

