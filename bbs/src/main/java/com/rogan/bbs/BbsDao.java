package com.rogan.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDao {
    
    @Autowired
    private JdbcTemplate template;
    
    public List<User> listForBeanPropertyRowMapper(){
        String query = "SELECT * FROM user";
        
            
        return template.query(query, new BeanPropertyRowMapper<User>(User.class));
    }
    
    public int insert (User user){
        String query =  "INSERT INTO user(user_id,user_pwd) VALUES(?, ?)";
        return template.update(query,user.getUserId(), user.getUserPwd());

    }
    
}
