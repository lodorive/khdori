package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.ClientDto;

public interface ClientDao {
	
	void insert(ClientDto clientDto);
	List<ClientDto> selectList();
	ClientDto selectOne(String clientId);
	boolean update(ClientDto clientDto);
	boolean delete(String clientId);
	
}
