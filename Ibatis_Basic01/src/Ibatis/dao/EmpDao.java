package Ibatis.dao;

import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import Ibatis.dto.Emp;

public class EmpDao {
	//CRUD 
	private static EmpDao instance = new EmpDao();
	private SqlMapClient sqlMap;
	private EmpDao() {
		Reader reader;
		try {
			 reader =  Resources.getResourceAsReader("Config/SqlMapConfig.xml");
			 sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		}catch(Exception e) {
			
		}
	}
	
	public static EmpDao getinstance() {
		return instance;
	}
	
	
	public void insertEmp(Emp e) throws SQLException {
		//values(?,?,?,?)
		//pstmt.setInt(e.getEmpno())
		//pstmt.setString(e.getEname()) ...
		 sqlMap.insert("insertEmp",e);
	}
	public Emp SelectEmp(String ename) throws SQLException {
		
		return (Emp)sqlMap.queryForObject("selectEmp",ename);
		
		//Emp e = new Emp();
		//e.setEmpno(rs.getInt(1));
		//.....
	}
}
