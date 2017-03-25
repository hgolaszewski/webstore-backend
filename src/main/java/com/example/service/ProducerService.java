package com.example.service;

import com.example.domain.Producer;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
public interface ProducerService {
	public Producer addProducer(Producer producer);

	public List<Producer> addProducers(List<Producer> producers);
	
	public Producer getProducerByName(String name);

	public List<Producer> listProducers();

	public Producer updateProducer(Producer producer);
	
	public void deleteProducer(Producer producer);

	public void deleteProducer(short id);
}
