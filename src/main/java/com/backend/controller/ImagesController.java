package com.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.dto.CategoryDto;
import com.backend.dto.ImagesDto;
import com.backend.entity.Image;

import com.backend.service.ImageService;


@RestController
@RequestMapping("/api/image")
@CrossOrigin("*")
public class ImagesController {
	@Autowired
	ImageService imageService;
//
//	@PostMapping("/createProduct")
//	public Image createProduct(@RequestBody Image image) {
//		return imageService.createProduct(image);
//	}
	
//	   @PostMapping("/create")
//	    public ResponseEntity<ImagesDto> createCategory(@Validated @RequestBody ImagesDto imagesDto){
//
//
//	       try {
//	    	   ImagesDto created =this. imageService.createCategory(imagesDto);
//	        return new ResponseEntity<>(created,HttpStatus.CREATED);
//	       } catch (Exception e) {
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	       } 
//
//	    }
	 @PostMapping("/upload/{productId}")
	    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,@PathVariable("productId") Long productId) {
		 String fileName = imageService.saveImage(file,productId);
	        return ResponseEntity.ok().body("Image uploaded successfully with filename: " + fileName);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
	        byte[] imageData = imageService.getImageById(id);
	        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
	    }
//	    @PutMapping("/update/{CategoryId}")
//	    public ResponseEntity<ImagesDto> updateCategory(@PathVariable Long CategoryId ,@RequestBody CategoryDto categoryDto){
//
//
//	       try {
//	        CategoryDto updated =this. imageService.updateCategory(CategoryId, categoryDto);
//	        return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
//	       } catch (Exception e) {
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	       } 
//
//	    }
	    
	    @GetMapping("/all")
	    public ResponseEntity<List<ImagesDto>> GetAllCategories(){



	       try {
	       List< ImagesDto > categoryList =this. imageService.getAllCategories();
	        return new ResponseEntity<>(categoryList,HttpStatus.OK);
	       } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       } 

	    }
	    @GetMapping("/getCategory/{CategoryId}")
	    public ResponseEntity<ImagesDto> GetAllCategories(@PathVariable Long imageId){


	       try {
	    	   ImagesDto categoryList =this. imageService.getCategoryById(imageId);
	        return new ResponseEntity<>(categoryList,HttpStatus.OK);
	       } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       } 

	    }
	    
}

