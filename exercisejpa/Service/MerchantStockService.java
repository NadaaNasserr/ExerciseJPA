package com.example.exercisejpa.Service;


import com.example.exercisejpa.Model.MerchantStock;
import com.example.exercisejpa.Repository.MerchantStockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MerchantStockService {



    private final MerchantStockRepository merchantStockRepository;

    public List<MerchantStock> getAllMerchantStock(){
        return merchantStockRepository.findAll();
    }


    public void addMerchantStock(MerchantStock merchantStock){
        merchantStockRepository.save(merchantStock);
    }

    public Boolean updateMerchantStock(Integer id , MerchantStock merchantStock){

        MerchantStock oldMerchantStock= merchantStockRepository.getById(id);
        if(oldMerchantStock==null){
            return false;
        }


        oldMerchantStock.setProductId(merchantStock.getProductId());
        oldMerchantStock.setMerchantId(merchantStock.getMerchantId());
        oldMerchantStock.setStock(merchantStock.getStock());




        merchantStockRepository.save(oldMerchantStock);
        return true;
    }
    public Boolean deleteMerchantStock(Integer id){

        MerchantStock merchantStock = merchantStockRepository.getById(id);
        if(merchantStock == null){
            return false;
        }
        merchantStockRepository.delete(merchantStock);
        return true;
    }



}





