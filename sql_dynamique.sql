
set serveroutput on;

create or replace procedure ex3 ( t varchar2) is
	texte varchar2(200) := 'drop table';
begin 
	texte := texte ||' '|| t;
	--texte := texte || t; -- bug
	dbms_output.put_line (texte);
	execute immediate texte;
end;
/

drop table s;

create table s(a integer);

insert into s values (7);

select * from s;

execute ex3 ('s');
select * from s;


