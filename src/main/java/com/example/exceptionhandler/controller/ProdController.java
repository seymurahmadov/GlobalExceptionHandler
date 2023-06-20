package com.example.exceptionhandler.controller;


import com.example.exceptionhandler.dto.ProdDto;
import com.example.exceptionhandler.entity.ProductEntity;
import com.example.exceptionhandler.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdController {

    private final ProductService service;

    @PostMapping("/save")
    public void saveProd(@RequestBody ProdDto prodDto){
        service.saveProducts(prodDto);
    }

    @GetMapping("/get-all")
    public List<ProductEntity> getAll(){
     return service.getAll();
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody ProdDto dto){
        service.deleteProduct(dto);
    }

    @PutMapping("/update")
    public ProductEntity updateProduct(@RequestBody ProdDto dto){
     return   service.updateProduct(dto);
    }
}
