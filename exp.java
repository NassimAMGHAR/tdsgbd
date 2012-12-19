/*@lineinfo:filename=exp*//*@lineinfo:user-code*//*@lineinfo:1^1*/
// sqlj 1
import java.io.*;
import java.sql.*;
import oracle.sqlj.runtime.Oracle;

/* 
drop table personne ;
create table personne ( nom varchar2(10), age integer);
insert into personne values ('tot', 23);
insert into personne values ('titi',23);
select * from personne;
*/

public class exp {
	public static void main (String [] args) throws SQLException {
		Oracle.connect(
		 "jdbc:oracle:thin:@servora:1521:dbinfo",
		 "namghar_a",
		 "r4g1h3po",
		 true// gestion des transactions
		);
 		/*@lineinfo:generated-code*//*@lineinfo:23^4*/

//  ************************************************************
//  #sql { update personne set age = age - 1 where nom = 'toto'
//  		 };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OraclePreparedStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = sqlj.runtime.ref.DefaultContext.getDefaultContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
   String theSqlTS = "update personne set age = age - 1 where nom = 'toto'";
   __sJT_st = __sJT_ec.prepareOracleBatchableStatement(__sJT_cc,"0exp",theSqlTS);
  // execute statement
   __sJT_ec.oracleExecuteBatchableUpdate();
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:25^3*/
		Oracle.close();
	}
}/*@lineinfo:generated-code*/