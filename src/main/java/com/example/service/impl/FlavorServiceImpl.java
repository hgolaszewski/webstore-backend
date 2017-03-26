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
	public Flavor addFlavor(Flavor flavor) {
		return flavorRepository.save(flavor);
	}

	@Override
	public Flavor updateFlavor(Flavor flavor) {
		return flavorRepository.save(flavor);
	}

	@Override
	public List<Flavor> listFlavor() {
		return flavorRepository.findAll();
	}

	@Override
	public Flavor getFlavorById(short id) {
		return null;
	}

	@Override
	public Flavor getFlavorByName(String name) {
		return null;
	}

	@Override
	public void removeFlavor(short id) {
		flavorRepository.delete(id);
	}
}
