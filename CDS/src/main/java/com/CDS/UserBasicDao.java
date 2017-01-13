package com.CDS;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class UserBasicDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate paramJdbcTemplate;

	public List<UserBasic> getUserList() {
		return JdbcTemplate.query("select *from user_basic_tbl", new BeanPropertyRowMapper<UserBasic>(UserBasic.class));
	}

	public boolean isUserAuthorizedBy(String userId, String userPwd) {
		String sql = "SELECT COUNT(*) FROM user_basic_tbl " + "WHERE user_id =:user_id " + "AND user_pwd =:user_pwd";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("user_id", userId);
		params.addValue("user_pwd", userPwd);

		Integer conunt = paramJdbcTemplate.queryForObject(sql, params, Integer.class);

		return conunt == 0 ? false : true;
	}

	public UserBasic getUserInfoBy(String userId) {
		//String sql = "select * from user_basic_tbl WHERE user_id =:user_id AND user_pwd =:user_pwd";
		String sql = "select * from user_basic_tbl WHERE user_id =:user_id";
		//System.out.println(sql);
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("user_id", userId);
		//params.addValue("user_pwd", userPwd);
		
		return paramJdbcTemplate.query(sql, params,new BeanPropertyRowMapper<UserBasic>(UserBasic.class)).get(0);
		
	}

}
