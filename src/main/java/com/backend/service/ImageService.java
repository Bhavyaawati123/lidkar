package com.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.backend.dto.CategoryDto;
import com.backend.dto.ImagesDto;
import com.backend.entity.Image;
import com.backend.entity.Product;

public interface ImageService {
//	Image createProduct(Image image);
//	ImagesDto createCategory(ImagesDto imagesDto);
	String saveImage(MultipartFile file, Long productId);
//	ImagesDto updateCategory(Long productId, ImagesDto imagesDto);

	    List<ImagesDto> getAllCategories();

	    ImagesDto getCategoryById(Long imageId);

	    String deleteCategory(Long imageId);

		byte[] getImageById(Long id);
}
