
create sequence seq start with 100;

create or replace procedure traitement2 ( idcc in client.idc%type, vil in village.destination%type, jour in sejour.jour%type,
					 idvv out village.idv%type, v_ids out sejour.ids%type, activ out village.activite%type ) is

x village.prix%type;
y integer;
 
begin
	select idv, prix, activite
		into idvv,x,activ		 
		from village 
	where destination = vil order by prix;
	
	x := seq.nextval;
	v_ids := x;
	insert into sejour values(x, idvv, idcc, jour);

	update client 
		set avoir = avoir - x where idc = idcc;
	
end;
/


create sequence seq start with 100;

create or replace procedure traitement2_gen ( idcc in int ,vil in varchar2, jour in int,
					 idvv out int, v_ids out int, activ out varchar2, utilisateur in varchar2 ) is
	req varchar2(100); 
begin
	req := 'begin  '||utilisateur||'.traitement2(:1,:2,:3,:4,:5,:6);end;';
	execute immediate req using idcc,vil,jour,out idvv,out v_ids,out activ;
	
end;
/


declare
idcc  int ;
vil   varchar2(10);
jour  int;
idvv  int;
v_ids int;
activ varchar2(10);
use   varchar2(30);

begin

idcc := 1;
vil := 'hawai';
jour := 33;
use := 'namghar_a';

traitement2_gen (idcc,vil,jour,idvv,v_ids,activ,use);

dbms_output.put_line(idvv);
dbms_output.put_line(v_ids);
dbms_output.put_line(activ);

end;
/


----create or replace procedure traitement1_gen(
	--l in varchar2,nom_p in client.nom%
