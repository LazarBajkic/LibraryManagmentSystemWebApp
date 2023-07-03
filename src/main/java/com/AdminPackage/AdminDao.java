package com.AdminPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

	public boolean checkAdminCreds(String ID,String uname) throws ClassNotFoundException, SQLException {
		
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","Ceramida");
			PreparedStatement st = con.prepareStatement("Select ID,Name from admins where ID=? AND Name=?");
			
			st.setString(2, uname);
			st.setString(1, ID);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
	}
	
}
