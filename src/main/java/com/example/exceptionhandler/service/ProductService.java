package com.example.exceptionhandler.service;


import com.example.exceptionhandler.dto.ProdDto;
import com.example.exceptionhandler.entity.ProductEntity;
import com.example.exceptionhandler.exception.ProductNotFoundException;
import com.example.exceptionhandler.exception.ProductNotNullException;
import com.example.exceptionhandler.repositrory.ProdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProdRepository repository;

    public ProductEntity saveProducts(ProdDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .productName(dto.getProductName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .color(dto.getColor())
                .count(dto.getCount())
                .size(dto.getSize())
                .build();

        if (entity.getProductName().isBlank() || entity.getProductName().isEmpty()){
            throw new ProductNotNullException("Product name must be not null");
        }

      return repository.save(entity);
    }

    public void deleteProduct(ProdDto dto) {
//        ProductEntity entity = repository.findById(dto.getId()).orElseThrow();
        ProductEntity entity = repository.findById(dto.getId())
                .orElseThrow(() -> new ProductNotFoundException("Customer id: " + dto.getId()));

        repository.delete(entity);
    }

    public List<ProductEntity> getAll() {

        Iterable<ProductEntity> all = repository.findAll();
        List<ProductEntity> list = new ArrayList<>();

        all.forEach(list::add);
        return list;
    }


    public ProductEntity updateProduct(ProdDto dto) {
        ProductEntity entity = repository.findById(dto.getId()).orElseThrow();
        entity.setProductName(dto.getProductName());
        entity.setCategory(dto.getCategory());
        entity.setPrice(dto.getPrice());
        entity.setColor(dto.getColor());
        entity.setCount(dto.getCount());
        entity.setSize(dto.getSize());

        return repository.save(entity);
    }
}