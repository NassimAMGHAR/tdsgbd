/*@lineinfo:filename=Traitement3*//*@lineinfo:user-code*//*@lineinfo:1^1*/

// sqlj TD coonexion

import java.io.*;
import java.sql.*;
import oracle.sqlj.runtime.Oracle;

public class Traitement3 {

	static void connect (String nom, String mdp)
		throws SQLException
	{
		Oracle.connect(
			 "jdbc:oracle:thin:@servora:1521:dbinfo",
			 nom,
			 mdp,
			 true// gestion des transactions
			);

	}

	static void deconnect ()
		throws SQLException	
	{
		Oracle.close();
	}


	 static String lireClavier() {
		// Dans cette fonction l'exception est catchee pour ne pas avoir a la 
		// gerer dans le main, et donc mieux voir les exceptions BD. 
		try {
		    BufferedReader clavier =
			new BufferedReader(new InputStreamReader(System.in));
		    return clavier.readLine();
		} catch (Exception e) {
		    return "erreur dans fonction lireClavier";
		}
	    }

	// traitement 3
	static void traitement3()
		throws SQLException	
	{

	System.out.println(" Traitement 3 ");
		System.out.print(" Donner le jour des sejour a supprimer : ");
		int x = Integer.parseInt(lireClavier());
		
		int pnb = 0;
		int nnb = 0;		

		/*@lineinfo:generated-code*//*@lineinfo:54^3*/

//  ************************************************************
//  #sql { select count(*)  from sejour 
//  		 };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OraclePreparedStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = sqlj.runtime.ref.DefaultContext.getDefaultContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  oracle.jdbc.OracleResultSet __sJT_rs = null;
  try {
   String theSqlTS = "select count(*)   from sejour";
   __sJT_st = __sJT_ec.prepareOracleStatement(__sJT_cc,"0Traitement3",theSqlTS);
   if (__sJT_ec.isNew())
   {
     __sJT_st.setFetchSize(2);
   }
   // execute query
   __sJT_rs = __sJT_ec.oracleExecuteQuery();
   if (__sJT_rs.getMetaData().getColumnCount() != 1) sqlj.runtime.error.RuntimeRefErrors.raise_WRONG_NUM_COLS(1,__sJT_rs.getMetaData().getColumnCount());
   if (!__sJT_rs.next()) sqlj.runtime.error.RuntimeRefErrors.raise_NO_ROW_SELECT_INTO();
   // retrieve OUT parameters
   pnb = __sJT_rs.getInt(1); if (__sJT_rs.wasNull()) throw new sqlj.runtime.SQLNullException();
   if (__sJT_rs.next()) sqlj.runtime.error.RuntimeRefErrors.raise_MULTI_ROW_SELECT_INTO();
  } finally { if (__sJT_rs!=null) __sJT_rs.close(); __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:56^3*/
				
 		/*@lineinfo:generated-code*//*@lineinfo:58^4*/

//  ************************************************************
//  #sql { delete from sejour where jour < :x
//  		 };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OraclePreparedStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = sqlj.runtime.ref.DefaultContext.getDefaultContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
   String theSqlTS = "delete from sejour where jour <  :1";
   __sJT_st = __sJT_ec.prepareOracleBatchableStatement(__sJT_cc,"1Traitement3",theSqlTS);
   // set IN parameters
   __sJT_st.setInt(1,x);
  // execute statement
   __sJT_ec.oracleExecuteBatchableUpdate();
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:60^3*/

		/*@lineinfo:generated-code*//*@lineinfo:62^3*/

//  ************************************************************
//  #sql { select count(*)  from sejour 
//  		 };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OraclePreparedStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = sqlj.runtime.ref.DefaultContext.getDefaultContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  oracle.jdbc.OracleResultSet __sJT_rs = null;
  try {
   String theSqlTS = "select count(*)   from sejour";
   __sJT_st = __sJT_ec.prepareOracleStatement(__sJT_cc,"2Traitement3",theSqlTS);
   if (__sJT_ec.isNew())
   {
     __sJT_st.setFetchSize(2);
   }
   // execute query
   __sJT_rs = __sJT_ec.oracleExecuteQuery();
   if (__sJT_rs.getMetaData().getColumnCount() != 1) sqlj.runtime.error.RuntimeRefErrors.raise_WRONG_NUM_COLS(1,__sJT_rs.getMetaData().getColumnCount());
   if (!__sJT_rs.next()) sqlj.runtime.error.RuntimeRefErrors.raise_NO_ROW_SELECT_INTO();
   // retrieve OUT parameters
   nnb = __sJT_rs.getInt(1); if (__sJT_rs.wasNull()) throw new sqlj.runtime.SQLNullException();
   if (__sJT_rs.next()) sqlj.runtime.error.RuntimeRefErrors.raise_MULTI_ROW_SELECT_INTO();
  } finally { if (__sJT_rs!=null) __sJT_rs.close(); __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:64^3*/		

		System.out.println(" Rows : "+(pnb - nnb));	
	
	}

	// consultation
	static void consultationSejoursClient()
		throws SQLException	
	{
		System.out.println(" Consultation sejour ");
		System.out.print(" Donner l'id client : ");
		int x = Integer.parseInt(lireClavier());
		
		/*@lineinfo:generated-code*//*@lineinfo:78^3*/

//  ************************************************************
//  SQLJ iterator declaration:
//  ************************************************************

class cons
extends sqlj.runtime.ref.ResultSetIterImpl
implements sqlj.runtime.NamedIterator
{
  public cons(sqlj.runtime.profile.RTResultSet resultSet)
    throws java.sql.SQLException
  {
    super(resultSet);
    idsNdx = findColumn("ids");
    idcNdx = findColumn("idc");
    idvNdx = findColumn("idv");
    jourNdx = findColumn("jour");
    m_rs = (oracle.jdbc.OracleResultSet) resultSet.getJDBCResultSet();
  }
  private oracle.jdbc.OracleResultSet m_rs;
  public int ids()
    throws java.sql.SQLException
  {
    int __sJtmp = m_rs.getInt(idsNdx);
    if (m_rs.wasNull()) throw new sqlj.runtime.SQLNullException(); else return __sJtmp;
  }
  private int idsNdx;
  public int idc()
    throws java.sql.SQLException
  {
    int __sJtmp = m_rs.getInt(idcNdx);
    if (m_rs.wasNull()) throw new sqlj.runtime.SQLNullException(); else return __sJtmp;
  }
  private int idcNdx;
  public int idv()
    throws java.sql.SQLException
  {
    int __sJtmp = m_rs.getInt(idvNdx);
    if (m_rs.wasNull()) throw new sqlj.runtime.SQLNullException(); else return __sJtmp;
  }
  private int idvNdx;
  public int jour()
    throws java.sql.SQLException
  {
    int __sJtmp = m_rs.getInt(jourNdx);
    if (m_rs.wasNull()) throw new sqlj.runtime.SQLNullException(); else return __sJtmp;
  }
  private int jourNdx;
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:78^54*/
		cons iter;
		/*@lineinfo:generated-code*//*@lineinfo:80^3*/

//  ************************************************************
//  #sql iter = { select * from sejour where idc = :x		
//  		 };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OraclePreparedStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = sqlj.runtime.ref.DefaultContext.getDefaultContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "select * from sejour where idc =  :1";
   __sJT_st = __sJT_ec.prepareOracleStatement(__sJT_cc,"3Traitement3",theSqlTS);
   // set IN parameters
   __sJT_st.setInt(1,x);
   // execute query
   iter = new cons(new sqlj.runtime.ref.OraRTResultSet(__sJT_ec.oracleExecuteQuery(),__sJT_st,"3Traitement3",null));
  } finally { __sJT_ec.oracleCloseQuery(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:82^3*/
		
		while(iter.next()){
		
		System.out.println(" id sejour "+iter.ids()+"\n id client " + iter.idc() + "\n id village "+iter.idv()+"\n jour "+iter.jour()+"\n ------------");

		};
	
	}

	public static void main (String [] args) throws SQLException {
		
		
		connect("namghar_a","r4g1h3po");
		
		while (true) {
		    System.out.println("-------------------------------");
		    System.out.println("Bienvenue dans le menu Menu");
		    //System.out.println("1 : traitement1");
		    System.out.println("2 : consultation Sejours Client ");
		    System.out.println("3 : traitement3");	 
		    //System.out.println("4 : traitement1 proc");
		    //System.out.println("5 : traitement2 proc");   
		    System.out.println("9 : deconnexion");
		    System.out.println("0 : terminer");
		    System.out.print("Entrez votre choix : ");

		    int n = Integer.parseInt(lireClavier());

		    switch (n) {
		   // case 1 : traitement1(); break;
		    case 2 : consultationSejoursClient();break;
		    case 3 : traitement3(); break;
		   // case 4 : traitement1proc(); break;
		   // case 5 : traitement2proc(); break;
		    case 9 : deconnect(); break;
		    case 0 : return;
		    }
		}
		
		
	}
}/*@lineinfo:generated-code*/