package com.example.service.impl;

import com.example.domain.Opinion;
import com.example.domain.Product;
import com.example.repository.OpinionRepository;
import com.example.repository.ProductRepository;
import com.example.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hubertus on 3/9/17.
 */
@Service
@Transactional
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    OpinionRepository opinionRepository;

    @Override
    public Opinion addOpinion(Opinion opinion) {
        return null;
    }

    @Override
    public List<Opinion> listOpinionsByProduct(Product product) {
        return opinionRepository.findByProduct(product);
    }

    @Override
    public Opinion updateOpinion(Opinion opinion) {
        return null;
    }

    @Override
    public void deleteOpinion(Opinion opinion) {

    }

}
