-- initialize database, create tables and built-in objects
drop table if exists hotels cascade;
drop table if exists users cascade;
drop table if exists services cascade;
drop table if exists hotels_services cascade;
drop table if exists categories cascade;
drop table if exists rooms cascade;
drop table if exists bookings cascade;

create table hotels
(
    id      serial primary key,
    name    varchar(30),
    suburb  varchar(30),
    address varchar(50)
);

create table users
(
    id       serial primary key,
    username varchar(30),
    password varchar(30),
    full_name varchar(30),
    hotelId  integer references hotels (id),
    role     varchar(30)
);

create table services
(
    id   serial primary key,
    name varchar(30)
);

insert into services (name) values ('Parking');
insert into services (name) values ('Wifi');
insert into services (name) values ('Restaurant');
insert into services (name) values ('Massage');
insert into services (name) values ('Swimming Pool');

create table hotels_services
(
    id        serial primary key,
    hotelId   integer references hotels (id),
    serviceId integer references services (id)
);

create table categories
(
    id      serial primary key,
    name    varchar(30),
    hotelId integer references hotels (id),
    price   float
);

create table rooms
(
    id         serial primary key,
    categoryId integer references categories (id),
    number     varchar(30)
);

-- create table bookings(
--     id serial primary key,
--     userId integer references users(id),
--     startDate date,
--     endDate date,
--     roomId integer references rooms(id)
-- );



