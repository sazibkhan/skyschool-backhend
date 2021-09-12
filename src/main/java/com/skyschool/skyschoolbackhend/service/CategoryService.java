package com.skyschool.skyschoolbackhend.service;

import com.skyschool.skyschoolbackhend.dto.Request.CategoryRequest;
import com.skyschool.skyschoolbackhend.dto.Response.CategoryResponse;
import com.skyschool.skyschoolbackhend.entity.CategoryPanel;
import com.skyschool.skyschoolbackhend.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryPanel createCategory(CategoryRequest categoryRequest){

        CategoryPanel categoryPanel=new CategoryPanel();
        String uuId= UUID.randomUUID().toString();

        categoryPanel.setId(uuId);
        categoryPanel.setCategoryName(categoryRequest.getCategoryName());
        categoryRepository.saveAndFlush(categoryPanel);
        return categoryPanel;

    }

    public List<CategoryResponse> getAllCategoryInformation(){
        List<CategoryResponse>categoryResponseArrayList=new ArrayList<>();
        List<CategoryPanel> categoryPanelList=categoryRepository.findAll();

        for(CategoryPanel categoryPanel:categoryPanelList){

            CategoryResponse categoryResponse=new CategoryResponse();
            categoryResponse.setId(categoryPanel.getId());
            categoryResponse.setCategoryName(categoryPanel.getCategoryName());
            categoryResponseArrayList.add(categoryResponse);
        }
        return categoryResponseArrayList;
    }

    public CategoryResponse getCategoryInformationById(String categoryId){

        Optional<CategoryPanel>optionalCategoryPanel=categoryRepository.findAllById(categoryId);

            if(!optionalCategoryPanel.isPresent()){
                throw  new RuntimeException("Category Id Not Present");
            }
            CategoryPanel categoryPanel=new CategoryPanel();

            return CategoryResponse.builder()
                    .id(categoryPanel.getId())
                    .categoryName(categoryPanel.getCategoryName())
                    .build();
    }

    public void updateCategoryInformationById(CategoryRequest categoryRequest, String categoryId){

        Optional<CategoryPanel>optionalCategoryPanel=categoryRepository.findAllById(categoryId);
            if(!optionalCategoryPanel.isPresent()){
                throw new RuntimeException("Category Id Not Present");
            }
        CategoryPanel categoryPanel=optionalCategoryPanel.get();
        categoryPanel.setCategoryName(categoryRequest.getCategoryName());
        categoryRepository.save(categoryPanel);

    }

    public ResponseEntity<Void> deleteCategoryInformationBy(String categoryId){
        Optional<CategoryPanel>optionalCategoryPanel=categoryRepository.findAllById(categoryId);
        if(!optionalCategoryPanel.isPresent()){
            throw new RuntimeException(" Category Id Not Present");
        }
        CategoryPanel categoryPanel=optionalCategoryPanel.get();
        categoryRepository.delete(categoryPanel);
        return  null;
    }




}
