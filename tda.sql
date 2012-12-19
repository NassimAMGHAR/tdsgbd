drop table loisir;
create table loisir(nom varchar2(10), age integer, activite varchar2(10));
insert into loisir values('Riton',22,'SGBD');
insert into loisir values('Rita',21,'tango');
insert into loisir values('Jeanne',20,'sieste');
select * from loisir;

create or replace procedure traitement(n  loisir.nom%type) is
x loisir.age%type;
y loisir.activite%type;
begin
	update loisir set age = age + 1 where nom = n;
	select age, activite
	 into x, y
	 from loisir 
 	 where nom = n;
	update loisir
	 set activite = y
	 where age = x;
end;
/


show errors;

--set serveroutput on

execute traitement('Rita');
select * from loisir;

create or replace function f return integer is
 n integer;
begin
	select count(*) into n from loisir;
	return n;
end;
/

execute dbms_output.put_line(f);


declare
 x varchar2(10);
begin
 x := 'Hello!';
 dbms_output.put_line(x);
end;
/


create or replace procedure q(x in integer, y out integer) is
begin
	y := x + 1;
end;
/


create or replace procedure crountch is
 a integer;
begin 
	q(4,a);
	dbms_output.put_line(a);
end;
/

execute crountch;
