package com.Register.Form.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO {
    public int k= 0;
    public int update(UserBean ub) {
    	try {
    	Connection con = DbConnection.getCon();
    	PreparedStatement ps = con.prepareStatement
    			("update UserReg52 set addr=?,mid=?,phno=? where uname=? and pword=?");
    	ps.setString(1, ub.getAddr());
    	ps.setString(2, ub.getmId());
    	ps.setLong(3, ub.getPhno());
    	ps.setString(4, ub.getuName());
    	ps.setString(5, ub.getpWord());
    	k = ps.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return k;
    }
}
