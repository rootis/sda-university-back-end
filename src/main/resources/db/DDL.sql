-- DDL
CREATE TABLE university
(
    id int unsigned auto_increment primary key,
    code varchar(10) not null,
    title varchar(250) not null
);

CREATE TABLE study_program
(
    id int unsigned auto_increment primary key,
    title varchar(250) not null,
    university_id int unsigned not null,
    foreign key (university_id) references university(id)
);
