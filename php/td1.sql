

drop table produit;
create table produit (nom varchar2(30), prix integer, qte integer);
select * from produit;
insert into produit values ('cours java',10,7);
insert into produit values ('cours BD',50,3);
insert into produit values ('cours Baby-siting',70,50);
insert into produit values ('cours tango',100,3);
insert into produit values ('cours sieste',200,1);
select * from produit;

create or replace procedure p(x in integer , y out integer) is
begin
	y:=x+1;
end;
/

create or replace function f(x integer) return integer is 
begin
	return (x+1);
end;
/
