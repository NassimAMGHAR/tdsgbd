drop table t;

create table t(nom varchar2(10) primary key, age integer);
insert into t values('toto',19);
insert into t values('titi',21);
insert into t values('tutu',22);

select * from t;

create or replace package cours4 as
	procedure rajeunit( n t.nom%type);
	function f return integer;
end;
/


create or replace package body cours4 as

	procedure rajeunit( n t.nom%type) is
	begin
		update t set age = age - 1 where nom = n;
	end;

	function f return integer is
		n integer;
	begin
		select count(*) into n from t;
		return n;
	end;
end;
/


set serveroutput on;

execute cours4.rajeunit('toto');
execute dbms_output.put_line(cours4.f);


