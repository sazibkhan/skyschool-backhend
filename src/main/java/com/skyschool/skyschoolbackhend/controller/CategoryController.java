package com.skyschool.skyschoolbackhend.controller;

import com.skyschool.skyschoolbackhend.dto.Request.CategoryRequest;
import com.skyschool.skyschoolbackhend.dto.Response.CategoryResponse;
import com.skyschool.skyschoolbackhend.entity.CategoryPanel;
import com.skyschool.skyschoolbackhend.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/sky/school")
public class CategoryController {


    public final CategoryService categoryService;


    @PostMapping("category/insert")
    public ResponseEntity<CategoryPanel> createCategory(@RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity(categoryService.createCategory(categoryRequest), HttpStatus.CREATED);
    }

    @GetMapping("/category/get/allInformation")
    public ResponseEntity<List<CategoryResponse>> getAllCategoryData() {
        return new ResponseEntity( categoryService.getAllCategoryInformation(),HttpStatus.OK);
    }

    @GetMapping("/category/get/allInformation/by/{id}")
    public ResponseEntity<CategoryResponse> getCategoryDataByCategoryId(@PathVariable String id){
        return new ResponseEntity (categoryService.getCategoryInformationById(id),HttpStatus.OK);
    }

    @PutMapping("/category/get/Information/updateBy/{id}")
    public ResponseEntity <Void> getCategoryDataUpdateByCategoryId(@RequestBody CategoryRequest categoryRequest, @PathVariable String id){
        categoryService.updateCategoryInformationById(categoryRequest,id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/category/delete/Information/by/{id}")
    public ResponseEntity<Void> deleteCategoryDataByCategoryId(@PathVariable String id){
        return new ResponseEntity(categoryService.deleteCategoryInformationBy(id),HttpStatus.NO_CONTENT);
    }

}
