package com.kh.springhome.dao;

import com.kh.springhome.dto.CertDto;

public interface CertDao {
	void insert(CertDto certDto);
	boolean delete(String certEmail);
	CertDto selectOne(String certEmail);
}
