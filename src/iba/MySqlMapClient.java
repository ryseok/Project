package iba;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;



public class MySqlMapClient {
   private static final SqlMapClient sqlMap;	
   
   static {
	   try {
		String resource = "./iba/sqlMapConfig.xml";
		   Reader reader = Resources.getResourceAsReader(resource);
		   sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("MySqlMapConfig: "+ e);
	}	   
   }//static
	
   public static SqlMapClient getSqlMapInstance() {
	  return sqlMap; 
   }
}








