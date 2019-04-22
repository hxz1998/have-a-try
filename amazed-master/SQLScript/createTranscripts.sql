use amazed;

create table transcripts(
	userId varchar(255) primary key,
    transcript varchar(255) not null
);

alter table transcripts add foreign key(userId) references user(password);