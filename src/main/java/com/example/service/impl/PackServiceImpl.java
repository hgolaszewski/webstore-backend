package com.example.service.impl;

import com.example.domain.Pack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.PackRepository;
import com.example.service.PackService;

/**
 * Created by adam on 3/9/17.
 */
@Service
public class PackServiceImpl implements PackService{

	@Autowired
	private PackRepository packRepository;

	@Override
	public void addPack(Pack pack) {
		//packRepository.addPack(pack);
	}

	@Override
	public void updatePack(Pack pack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePack(short id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pack getPackById(short id) {
		return null;
		//return packRepository.getPackById(id);
	}
	
	
}
