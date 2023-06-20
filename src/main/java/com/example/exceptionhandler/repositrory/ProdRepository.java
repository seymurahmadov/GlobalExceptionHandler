package com.example.exceptionhandler.repositrory;


import com.example.exceptionhandler.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepository extends JpaRepository<ProductEntity,Long> {
}
