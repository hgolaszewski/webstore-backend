package com.example.service;

import com.example.domain.Pack;

/**
 * Created by adam on 3/9/17.
 */
public interface PackService {
	public void addPack(Pack pack);
	public void updatePack(Pack pack);
	public void removePack(short id);
	public Pack getPackById(short id);
}
