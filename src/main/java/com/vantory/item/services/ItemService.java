package com.vantory.item.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vantory.item.models.Item;
import com.vantory.item.repositories.CustomRepository;

@Service
public class ItemService {

	@Autowired
	private CustomRepository customRepository;

	public List<Item> getAllItems(String tableName, Long parentId) {
		return customRepository.findAllItems(tableName, parentId);
	}

}
