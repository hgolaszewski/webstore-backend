package com.example.service.impl;

import com.example.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.repository.ProducerRepository;
import com.example.service.ProducerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
@Service
@Transactional
public class ProducerServiceImpl implements ProducerService{
	
	@Autowired
	ProducerRepository producerRepository;

	@Override
	public Producer addProducer(Producer producer) {
		Producer retProducer = producerRepository.findProducerByName(producer.getName());
		if(retProducer == null){
			retProducer = producerRepository.save(producer);
		}
		return retProducer;
	}

	@Override
	public List<Producer> addProducers(List<Producer> producers) {
		List<Producer> retProducers = new ArrayList<>();
		producers.forEach(item->retProducers.add(addProducer(item)));
		return retProducers;
	}

	@Override
	public Producer getProducerByName(String name) {
		return producerRepository.findProducerByName(name);
	}

	@Override
	public List<Producer> listProducers() {
		return producerRepository.findAll();
	}

	@Override
	public Producer updateProducer(Producer producer) {
		return producerRepository.save(producer);
	}

	@Override
	public void deleteProducer(short id) {
		producerRepository.delete(id);
	}

	@Override
	public void deleteProducer(Producer producer) {
		producerRepository.delete(producer);
	}

}
