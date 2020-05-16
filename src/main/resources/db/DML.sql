-- DML
insert into university (code, title) values ('KTU', 'Kaunas University of Technology');
insert into university (code, title) values ('VU', 'Vilnius University');

insert into study_program (title, university_id) VALUES ('Multimedia Technologies', (select id from university where code = 'KTU'));
insert into study_program (title, university_id) VALUES ('Informatics', (select id from university where code = 'KTU'));
insert into study_program (title, university_id) VALUES ('Software Systems', (select id from university where code = 'KTU'));
