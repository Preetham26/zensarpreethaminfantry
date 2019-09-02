package com.facebook2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.facebook2.entity.FacebookEmployee;


public class FacebookDAO implements FacebookDAOInterface
{
 private FacebookDAO()
 {}
	public static FacebookDAOInterface createDaoObject() 
	{
		return new FacebookDAO();
	}
	@Override
	public int createProfileDAO(FacebookEmployee fe) {
		int i=0;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@TRNW57SLPC0172.ind.zensar.com:1521:orcl","system","Zensar123");
					PreparedStatement ps = con.prepareStatement("insert into facebookemployee values(?,?,?,?)");
			ps.setString(1,fe.getName());
			ps.setString(2, fe.getPass());
			ps.setString(3,fe.getEmail());
			ps.setString(4,fe.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
}
