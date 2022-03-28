package com.mypack.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mypack.bean.User1;


public class EmpDao {
	
	private Connection conn;
	private PreparedStatement pst;
	private String sql;
	ResultSet rs;
	
	public EmpDao() throws ClassNotFoundException, SQLException, IOException{
		//ab na hi driver ko load krne ki req hai, na hi connection ko stablish krne ki req hai(baar- baar)
		conn=MyConnection.getConnection();
		
	}
	
	public Boolean validatin(User1 user) throws SQLException
	{
		sql="select * from user1 where username=? and password=?";
		pst= conn.prepareStatement(sql);
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		
		rs= pst.executeQuery();
		if(rs.next()==true)
			return true;
		else
			return false;
		
	}

}
