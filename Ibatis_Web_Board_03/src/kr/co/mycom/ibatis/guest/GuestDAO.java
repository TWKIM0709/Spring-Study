package kr.co.mycom.ibatis.guest;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class GuestDAO {
	private static SqlMapClient sqlMap = null;
	
    //클래스가 생성될때 자동으로 실행되는 static 블럭
	static {
		try {
			System.out.println("**********************");			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

		} catch (Exception e) {
			e.printStackTrace();		
		}
	}//static 블록
	
	//insertGuest(GuestDTO dto) : 글을 등록하는 메서드 
	public static void insertGuest(GuestDTO dto) throws SQLException{
		System.out.println(dto.toString());
		sqlMap.insert("insertGuest",dto);
	}
	
	public static void insertParamGuest(GuestDTO dto) throws SQLException{
		sqlMap.insert("insertMapGuest", dto);
	}
	
   //getGuestList() : 게시물 리스트를 얻어오는 메서드 
	public static List<GuestDTO> getGuestList() throws SQLException{
		
		return sqlMap.queryForList("getGuestList");
				
	}
	public static List<GuestDTO> SearchGuestList(String name) throws SQLException{
		
		return sqlMap.queryForList("getGuestSearch",name);		
	}
}
