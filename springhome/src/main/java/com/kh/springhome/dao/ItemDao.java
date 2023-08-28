package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.ItemDto;

public interface ItemDao {
	void insert(ItemDto itemDto);
	List<ItemDto> selectList();
	ItemDto selectOne(int itemNo);
	boolean update(ItemDto itemDto);
	boolean delete(int itemNo);	
}
