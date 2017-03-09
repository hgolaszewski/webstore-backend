package com.example.service.impl;

import com.example.domain.Flavor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.FlavorRepository;
import com.example.service.FlavorService;

import java.util.List;
/**
 * Created by adam on 3/9/17.
 */
@Service
public class FlavorServiceImpl implements FlavorService{

	@Autowired
	private FlavorRepository flavorRepository;

	@Override
	public void addFlavor(Flavor flavor) {
		//flavorRepository.addFlavor(flavor);
	}

	@Override
	public void updateFlavor(Flavor flavor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Flavor> listFlavor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flavor getFlavorById(short id) {
		return null;
		//return flavorRepository.getFlavorById(id);
	}

	@Override
	public Flavor getFlavorByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFlavor(short id) {
		// TODO Auto-generated method stub
		
	}
}
