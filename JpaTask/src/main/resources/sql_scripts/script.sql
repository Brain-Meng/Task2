create table t_people
(
    id             serial not null
        constraint t_people_pkey
            primary key,
    people_age     integer,
    people_name    varchar(255),
    people_sex     varchar(255),
    people_subject varchar(255)
);

alter table t_people
    owner to postgres;


