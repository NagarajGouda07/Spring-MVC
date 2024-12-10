package com.xworkz.product.component;

import com.xworkz.product.dto.ProductDTO;
import com.xworkz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Component
@RequestMapping("/")
public class ProductComponent {
    @Autowired
    ProductService productService;

    public ProductComponent(){
        System.out.println("This is a ProductComponent const...");
    }

    @RequestMapping("/product")
    public String product(ProductDTO dto, Model model){

        if (productService.validAndSave(dto)){
            System.out.println("It is a product = "+ dto);
            model.addAttribute("message","It is a product");
            model.addAttribute("productDTO",dto);

        }else {
            System.out.println("It is a not product");
            model.addAttribute("message", "It is a not product");
        }
        return "product.jsp";

    }

}
