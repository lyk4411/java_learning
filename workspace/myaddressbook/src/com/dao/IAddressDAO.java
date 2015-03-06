package com.dao;

import java.util.List;

import com.domain.Address;

public interface IAddressDAO {
	public Address create(Address addr) throws Exception;
	public void update(Address addr) throws Exception;
	public void remove(Address addr) throws Exception;
	public List<Address> findAll() throws Exception;
	public Address findById(int id) throws Exception;
}