package securitySpringBoot.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securitySpringBoot.demo.entities.Product;
import securitySpringBoot.demo.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProducts(Product product){
        return productRepository.save(product);
    }
    public List<Product> listProduct(){
        return productRepository.findAll();
    }
}
