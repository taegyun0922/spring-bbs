package com.CDS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameItemDao {  
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	public List<GameItem> getGameList(){
		return JdbcTemplate.query("select *from game_list_tbl", new BeanPropertyRowMapper<GameItem>(GameItem.class));
	}
}