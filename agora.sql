create database agora;

use agora;

-- Cria uma tabela
create table usuarios (
id int not null auto_increment primary key,
nome VARCHAR(30) NOT NULL,
senha VARCHAR(10) NOT NULL,
email VARCHAR(50) NOT NULL
);

select * from usuarios;

-- Inseri dados na tabela
insert into usuarios(id,nome,senha,email)
values
(1,"alex","123","alex@alex.alex");

delete from usuarios where id >= 10 ;


