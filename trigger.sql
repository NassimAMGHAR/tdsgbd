
create table sejour_archive (
ids int primary key,
idc int, 
idv int,
jour int not null,
avoir integer,
foreign key (idc) references client (idc),
foreign key (idv) references village (idv));

create or replace trigger archive_sejour 
	before delete
	on sejour
	for each row
declare
	avoir_aux integer;
begin
	select  avoir into avoir_aux from client where idc=:old.idc;
	insert into archive_sejour values (:old.ids,:old.idc,:old.idv,:old.jour,avoir_aux);	
end;
/

create or replace function village_place_libre (idv_p in integer,capacite_p in integer) return boolean is
	cursor c is
		select count(*) as count from sejour where idv = idv_p group by jour;
begin
	for x in c loop
	if (capacite_p - x.count <0) then
		return false;
	end if;
	end loop;
	return true;
end;
/

create or replace function f2 (idv in integer,jour in integer) return boolean is
begin
end;
/

create or replace trigger capacite_changement_village
	before update of capacite
	on village
	for each row
	when (new.capacite < old.capacite)
declare
	depassement exception;
begin
	if village_place_libre(:new.idv,:new.capacite) != true 
	then raise depassement;
	end if;
exception
	when depassement then dbms_output.put_line (' Depassement');
end;
/

create or replace trigger t2
	before insert
	on sejour
	for each row
declare
begin
end;
/
