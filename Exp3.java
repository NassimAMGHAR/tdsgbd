/*@lineinfo:filename=Exp3*//*@lineinfo:user-code*//*@lineinfo:1^1*/

//sqlj 3
import java.io.*;
import java.sql.*;
import oracle.sqlj.runtime.Oracle;

public class Exp3 {
	public static void main (String [] args) throws SQLException {
		Oracle.connect(
		 "jdbc:oracle:thin:@servora:1521:dbinfo",
		 "namghar_a",
		 "r4g1h3po",
		 true// gestion des transactions
		);

		/*@lineinfo:generated-code*//*@lineinfo:17^3*/

//  ************************************************************
//  SQLJ iterator declaration:
//  ************************************************************

class ex3
extends sqlj.runtime.ref.ResultSetIterImpl
implements sqlj.runtime.PositionedIterator
{
  public ex3(sqlj.runtime.profile.RTResultSet resultSet)
    throws java.sql.SQLException
  {
    super(resultSet, 2);
    m_rs = (oracle.jdbc.OracleResultSet) resultSet.getJDBCResultSet();
  }
  private oracle.jdbc.OracleResultSet m_rs;
  public String getCol1()
    throws java.sql.SQLException
  {
    return (String)m_rs.getString(1);
  }
  public int getCol2()
    throws java.sql.SQLException
  {
    int __sJtmp = m_rs.getInt(2);
    if (m_rs.wasNull()) throw new sqlj.runtime.SQLNullException(); else return __sJtmp;
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:17^32*/
		ex3 iter;
		/*@lineinfo:generated-code*//*@lineinfo:19^3*/

//  ************************************************************
//  #sql iter = { select nom, age from personne
//  		 };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OraclePreparedStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = sqlj.runtime.ref.DefaultContext.getDefaultContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "select nom, age from personne";
   __sJT_st = __sJT_ec.prepareOracleStatement(__sJT_cc,"0Exp3",theSqlTS);
   // execute query
   iter = new ex3(new sqlj.runtime.ref.OraRTResultSet(__sJT_ec.oracleExecuteQuery(),__sJT_st,"0Exp3",null));
  } finally { __sJT_ec.oracleCloseQuery(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:21^3*/

		String n = "";
	 
		int a = 0;

		while(true){
		/*@lineinfo:generated-code*//*@lineinfo:28^3*/

//  ************************************************************
//  #sql { fetch :iter 
//  		 };
//  ************************************************************

{
  ex3 __sJT_iter = iter;
  if (__sJT_iter.next())
  {
    n = __sJT_iter.getCol1();
    a = __sJT_iter.getCol2();
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:30^3*/
		if(iter.endFetch())
			break;
		System.out.println(n+ " a " + a + " ans");

		}
 			

		Oracle.close();
	}
}/*@lineinfo:generated-code*/