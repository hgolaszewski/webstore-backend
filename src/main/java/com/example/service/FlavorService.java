package com.example.service;

import com.example.domain.Flavor;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
public interface FlavorService {
	public void addFlavor(Flavor flavor);
	public void updateFlavor(Flavor flavor);
	public List<Flavor> listFlavor();
	public Flavor getFlavorById(short id);
	public Flavor getFlavorByName(String name);
	public void removeFlavor(short id);
}
