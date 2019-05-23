package com.n20145588109.main.service;

import com.n20145588109.main.domain.Basic;
import com.n20145588109.main.repository.BasicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {

    private BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public List<Basic> findAllBasicList(){
        return basicRepository.findAll();
    }

   public Basic findBasicByIdx(Long idx){ // Controller 는 Repository 에 직접접근 X (Service 통해)
        return basicRepository.findById(idx).orElse(new Basic());
   }
   public Basic saveBasic(Basic basic){
        return basicRepository.save(basic);
   }

   public void deleteBasicByIdx(Long idx){
        basicRepository.deleteById(idx);
   }
}
