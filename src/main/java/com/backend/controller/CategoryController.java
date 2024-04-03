package com.backend.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.CategoryDto;
import com.backend.service.CategorySevice;


@RestController
@RequestMapping("/category")
public class CategoryController {
   @Autowired
   private CategorySevice categorySevice;
   



    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Validated @RequestBody CategoryDto categoryDto){


       try {
        CategoryDto created =this.categorySevice.createCategory(categoryDto);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
       } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       } 

    }
    @PutMapping("/update/{CategoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long CategoryId ,@RequestBody CategoryDto categoryDto){


       try {
        CategoryDto updated =this.categorySevice.updateCategory(CategoryId, categoryDto);
        return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
       } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       } 

    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> GetAllCategories(){



       try {
       List< CategoryDto > categoryList =this.categorySevice.getAllCategories();
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
       } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       } 

    }
    @GetMapping("/getCategory/{CategoryId}")
    public ResponseEntity<CategoryDto> GetAllCategories(@PathVariable Long CategoryId){


       try {
        CategoryDto  categoryList =this.categorySevice.getCategoryById(CategoryId);
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
       } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       } 

    }
    
    
}
