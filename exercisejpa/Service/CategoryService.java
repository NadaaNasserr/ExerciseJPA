package com.example.exercisejpa.Service;


import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }


    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public Boolean updateCategory(Integer id , Category category){

        Category oldCategory = categoryRepository.getById(id);
        if(oldCategory==null){
            return false;
        }


        oldCategory.setName(category.getName());



        categoryRepository.save(oldCategory);
        return true;
    }
    public Boolean deleteCategory(Integer id){

        Category category = categoryRepository.getById(id);
        if(category == null){
            return false;
        }
        categoryRepository.delete(category);
        return true;
    }



}
