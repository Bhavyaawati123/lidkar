package com.backend.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.dto.ImagesDto;
import com.backend.dto.ProductDto;
import com.backend.entity.Image;
import com.backend.entity.Product;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.ImageRepo;
import com.backend.repository.ProductRepository;
import com.backend.service.ImageService;
import com.backend.service.ProductService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	ImageRepo imageRepositories;
	@Autowired
    private ProductRepository productRepo;


    @Autowired
    private ModelMapper modelMapper;

   

//	@Override
//	public ImagesDto updateCategory(Long productId, ImagesDto imagesDto) {
//		Image category =  productRepo.findById( productId)
//	            .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
	//
//	    category.setTitle(categoryDto.getTitle());
//	    category.setDescription(categoryDto.getDescription());
	//
//	    Category updatedCategory = categoryRepo.save(category);
//	    return categoryToDto(updatedCategory);
//	}

	@Override
	public List<ImagesDto> getAllCategories() {
		 List<Image> categories = imageRepositories.findAll();
		    return categories.stream()
		            .map(this::categoryToDto)
		            .collect(Collectors.toList());
	}

	@Override
	public ImagesDto getCategoryById(Long imageId) {
		Image category = imageRepositories.findById(imageId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", imageId));
	    return categoryToDto(category);
	}

	@Override
	public String deleteCategory(Long imageId) {
		 Image category = imageRepositories.findById(imageId)
		            .orElseThrow(() -> new ResourceNotFoundException("Category", "imageId", imageId));
		 imageRepositories.delete(category);
		    return "The Category is deleted Successfully";
		}

		public ImagesDto categoryToDto(Image savedCategory) {
		    return modelMapper.map(savedCategory, ImagesDto.class);
		}

		public Image dtoToCategory(ImagesDto imagesDto) {
		    return modelMapper.map(imagesDto, Image.class);
		}

		@Override
		public String saveImage(MultipartFile file, Long productId) {
		 
		    Product product = productRepo.findById(productId)
		            .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		    try {
		       
		        Image imageEntity = new Image();
		        imageEntity.setName(file.getOriginalFilename());
		        imageEntity.setImageData(file.getBytes());
	        
		      
		        imageEntity.setProduct(product);
		        
		       
		        imageRepositories.save(imageEntity);
		        
		        return file.getOriginalFilename();
		    } catch (IOException e) {
		        throw new RuntimeException("Failed to store image", e);
		    }
		}
		

		
	

		
		        
		  
		



	    @Override
	    public byte[] getImageById(Long id) {
	        Optional<Image> imageEntityOptional = imageRepositories.findById(id);
	        if (imageEntityOptional.isPresent()) {
	            return imageEntityOptional.get().getImageData();
	        } else {
	            throw new RuntimeException("Image not found with id: " + id);
	        }
	    }

}








