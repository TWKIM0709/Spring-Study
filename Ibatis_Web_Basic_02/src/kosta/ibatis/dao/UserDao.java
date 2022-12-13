package kosta.ibatis.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kosta.ibatis.dto.UserDto;
import kosta.ibatis.utils.IbatisUtil;

public class UserDao {

	public void insert(UserDto dto) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		//IbatisUtil.getSqlMapClient().insert(arg0)
		
		client.insert("insertuser", dto); //"insertuser" Map 파일 id 값
	}
	public void update(UserDto dto) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		client.update("updateuser", dto);
	}
	public void delete(String userid) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		client.delete("deleteuser",userid);
	}
	
	
	//전체 조회(UserDto  여러건)
	public List<UserDto> list() throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		return client.queryForList("selectAllUsers");
		//DTO 객체 row 개수만큼 생성 (List 담는 것)
		//List<UserDto>
		
		
	}
	
	public UserDto findById(String userid) throws SQLException{
		SqlMapClient client = IbatisUtil.getSqlMapClient();
		return (UserDto)client.queryForObject("selectAllByUserid", userid);
	}
	
}




