package com.pg.electronic.store.controllers;


import com.pg.electronic.store.dtos.ApiResponseMessage;
import com.pg.electronic.store.dtos.CategoryDto;
import com.pg.electronic.store.dtos.PageableResponse;
import com.pg.electronic.store.dtos.ProductDto;
import com.pg.electronic.store.services.CategoryService;
import com.pg.electronic.store.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private ProductService productService;

    // Create Controller
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        // Call Service to Save Object..!!
        CategoryDto categoryDto1 = categoryService.create(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }


    // Update Controller
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable String categoryId
    ){
        CategoryDto updatedCategory = categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }


    // Delete Controller
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponseMessage> deleteCategory(@PathVariable String categoryId){

        categoryService.delete(categoryId);
        ApiResponseMessage responseMessage = ApiResponseMessage.builder().message("Category is deleted Successfully..!!").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }


    // Get All Controller
    @GetMapping
    public ResponseEntity<PageableResponse<CategoryDto>> getAll(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ){
        PageableResponse<CategoryDto> pageableResponse = categoryService.getAll(pageNumber,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(pageableResponse, HttpStatus.OK);
    }


    // Get Single Controller
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingle(@PathVariable String categoryId){

        CategoryDto categoryDto = categoryService.get((categoryId));
        return ResponseEntity.ok(categoryDto);

    }


    //create product with category
    @PostMapping("/{categoryId}/products")
    public ResponseEntity<ProductDto> createProductWithCategory(
            @PathVariable("categoryId") String categoryId,
            @RequestBody ProductDto dto
    ) {
        ProductDto productWithCategory = productService.createWithCategory(dto, categoryId);
        return new ResponseEntity<>(productWithCategory, HttpStatus.CREATED);
    }

    //update category of product
    @PutMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<ProductDto> updateCategoryOfProduct(
            @PathVariable String categoryId,
            @PathVariable String productId
    ) {
        ProductDto productDto = productService.updateCategory(productId, categoryId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    //get products of categories
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<PageableResponse<ProductDto>> getProductsOfCategory(
            @PathVariable String categoryId,
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {

        PageableResponse<ProductDto> response = productService.getAllOfCategory(categoryId,pageNumber,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
