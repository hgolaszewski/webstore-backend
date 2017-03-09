package com.example.service;

import com.example.domain.Opinion;
import com.example.domain.Product;

import java.util.List;

/**
 * Created by adam on 3/9/17.
 */
public interface OpinionService {
	
	public Opinion addOpinion(Opinion opinion);
	
	public List<Opinion> listOpinionsByProduct(Product product);
	
	public Opinion updateOpinion(Opinion opinion);
	
	public void deleteOpinion(Opinion opinion);
	
}
