package com.xworkz.product.service;

import com.xworkz.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    public ProductServiceImpl(){
        System.out.println("This is a ProductServiceImpl const..");
    }

    @Override
    public boolean validAndSave(ProductDTO dto) {
        System.out.println("This is a ProductServiceImpl method...");
        return true;
    }
}
