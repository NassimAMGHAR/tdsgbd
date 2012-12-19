/*@lineinfo:filename=Exp2*//*@lineinfo:user-code*//*@lineinfo:1^1*/
//sqlj 2
import java.io.*;
import java.sql.*;
import oracle.sqlj.runtime.Oracle;

public class Exp2 {
	public static void main (String [] args) throws SQLException {
		Oracle.connect(
		 "jdbc:oracle:thin:@servora:1521:dbinfo",
		 "namghar_a",
		 "r4g1h3po",
		 true// gestion des transactions
		);

		String n = args[0];
		int a;
 		
		/*@lineinfo:generated-code*//*@lineinfo:19^3*/

//  ************************************************************
//  #sql { select age  from personne where nom = :n
//  		 };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OraclePreparedStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = sqlj.runtime.ref.DefaultContext.getDefaultContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  oracle.jdbc.OracleResultSet __sJT_rs = null;
  try {
   String theSqlTS = "select age   from personne where nom =  :1";
   __sJT_st = __sJT_ec.prepareOracleStatement(__sJT_cc,"0Exp2",theSqlTS);
   if (__sJT_ec.isNew())
   {
     __sJT_st.setFetchSize(2);
   }
   // set IN parameters
   __sJT_st.setString(1,n);
   // execute query
   __sJT_rs = __sJT_ec.oracleExecuteQuery();
   if (__sJT_rs.getMetaData().getColumnCount() != 1) sqlj.runtime.error.RuntimeRefErrors.raise_WRONG_NUM_COLS(1,__sJT_rs.getMetaData().getColumnCount());
   if (!__sJT_rs.next()) sqlj.runtime.error.RuntimeRefErrors.raise_NO_ROW_SELECT_INTO();
   // retrieve OUT parameters
   a = __sJT_rs.getInt(1); if (__sJT_rs.wasNull()) throw new sqlj.runtime.SQLNullException();
   if (__sJT_rs.next()) sqlj.runtime.error.RuntimeRefErrors.raise_MULTI_ROW_SELECT_INTO();
  } finally { if (__sJT_rs!=null) __sJT_rs.close(); __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:21^3*/

		System.out.println(n+" a " + a + " ans ");		

		Oracle.close();
	}
}/*@lineinfo:generated-code*/