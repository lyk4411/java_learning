package com.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.IAddressDAO;
import com.domain.Address;

public class MySQLAddressDAO implements IAddressDAO {
	private Connection con;
	public MySQLAddressDAO() throws Exception {
		con = MySQLUtil.getConnection();
	}
	
	@Override
	public Address create(Address addr) throws Exception {
		// TODO Auto-generated method stub 
		String sql = "insert into addresses(name,gender,birthday,mobile,phone,email)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement pSta = con.prepareStatement(sql);
		
		pSta.setString(1, addr.getName());
		pSta.setString(2, String.valueOf(addr.getGender()));
		pSta.setDate(3, addr.getBirthday());
		pSta.setString(4, addr.getMobile());
		pSta.setString(5, addr.getPhone());
		pSta.setString(6, addr.getEmail());
		
		pSta.executeUpdate();
		
		ResultSet rs = pSta.getGeneratedKeys();
		if(rs.next()){
			addr.setId(rs.getInt(1));
		}
		rs.close();
		pSta.close();
		return addr;
	}

	@Override
	public void update(Address addr) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update  addresses set name = ?, gender = ?,"
				+ "birthday = ?, mobile = ?, phone = ?, email = ? where id = ?";
		PreparedStatement pSta = con.prepareStatement(sql);
		
		pSta.setString(1, addr.getName());
		pSta.setString(2, String.valueOf(addr.getGender()));
		pSta.setDate(3, addr.getBirthday());
		pSta.setString(4, addr.getMobile());
		pSta.setString(5, addr.getPhone());
		pSta.setString(6, addr.getEmail());
		pSta.setInt(7, addr.getId());
		
		pSta.executeUpdate();
	}

	@Override
	public void remove(Address addr) throws Exception {
		// TODO Auto-generated method stub
		Statement sta = con.createStatement();
		sta.executeQuery("delete from addresses where id = " + addr.getId());
		
		sta.close();
	}

	@Override
	public List<Address> findAll() throws Exception {
		// TODO Auto-generated method stub 
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery("select * from addresses");
		
		ArrayList<Address> addresses = new ArrayList<Address>();
		while(rs.next()){
			Address addr = new Address();
			addr.setId(rs.getInt("id"));
			addr.setName(rs.getString("name"));
			addr.setGender(rs.getString("gender").charAt(0));
			addr.setBirthday(rs.getDate("birthday"));
			addr.setMobile(rs.getString("mobile"));
			addr.setPhone(rs.getString("phone"));
			addr.setEmail(rs.getString("email"));
	
			addresses.add(addr);
		}
		rs.close();
		sta.close();
		
		return addresses;
	}

	@Override
	public Address findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery("select * from addresses where id = " + id);
		
		Address addr = null;
		if(rs.next()){
			addr = new Address();
			addr.setId(rs.getInt("id"));
			addr.setName(rs.getString("name"));
			addr.setGender(rs.getString("gender").charAt(0));
			addr.setBirthday(rs.getDate("birthday"));
			addr.setMobile(rs.getString("mobile"));
			addr.setPhone(rs.getString("phone"));
			addr.setEmail(rs.getString("email"));
		}
		rs.close();
		sta.close();
		
		return addr;	
	}
}
