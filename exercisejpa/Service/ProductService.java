package com.example.exercisejpa.Service;


import com.example.exercisejpa.Model.Product;
import com.example.exercisejpa.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {



    private final ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }


    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Boolean updateProduct(Integer id , Product product){

        Product oldProduct= productRepository.getById(id);
        if(oldProduct==null){
            return false;
        }


        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setCategoryID(product.getCategoryID());


        productRepository.save(oldProduct);
        return true;
    }
    public Boolean deleteProduct(Integer id){

        Product product = productRepository.getById(id);
        if(product == null){
            return false;
        }
        productRepository.delete(product);
        return true;
    }




}



