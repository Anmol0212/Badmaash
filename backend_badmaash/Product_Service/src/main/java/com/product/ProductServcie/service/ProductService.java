package com.product.ProductServcie.service;

import com.product.ProductServcie.entity.Product;
import com.product.ProductServcie.entity.Images;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    String CreateProduct(Product product);
    String DeleteProduct(String  productId);
    String UpdateProduct(Product product);
    Product SearchProduct(String productId);
    List<Product> getALLProducts();
    List<Product> getALLProductsByProductsType(String productType);
    List<Product> getAllProductByRange(String choice,int minPrice, int maxPrice);
    List<Product> getLatestProducts();
    int saveImage(MultipartFile images);
    byte[] findImage(int id);



}
