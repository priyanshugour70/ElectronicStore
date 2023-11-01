package com.pg.electronic.store.services;

import com.pg.electronic.store.dtos.PageableResponse;
import com.pg.electronic.store.dtos.ProductDto;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {

    // Create
    ProductDto create(ProductDto productDto);

    // Update
    ProductDto update(ProductDto productDto, String productId);

    // Delete
    void delete(String productId);

    // Get Single
    ProductDto get(String productId);

    // Get all
    PageableResponse<ProductDto> getAll(
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortDir
    );

    // Get All : live
    PageableResponse<ProductDto> getAllLive(
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortDir
    );

    // search product
    PageableResponse<ProductDto> searchByTitle(
            String subTitle,
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortDir
    );


    //create product with category
    ProductDto createWithCategory(ProductDto productDto,String categoryId);

    //update category of product
    ProductDto updateCategory(String productId,String categoryId);
    PageableResponse<ProductDto> getAllOfCategory(String categoryId,int pageNumber,int pageSize,String sortBy, String sortDir);


    // other methods..
}
