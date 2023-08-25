package com.product.ProductServcie.service;

import com.product.ProductServcie.entity.Images;
import com.product.ProductServcie.entity.Product;
import com.product.ProductServcie.exception.ResourceNotFoundException;
import com.product.ProductServcie.repository.ImageRepository;
import com.product.ProductServcie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String CreateProduct(Product product) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        product.setPostedDate(now);
        productRepository.save(product);
        return "createdSuccessfully";

    }

    @Override
    public String DeleteProduct(String  productId) {
        Product product1=productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("ID NotExists"));
        productRepository.delete(product1);
        return "Successfully Deleted";

    }

    @Override
    public String UpdateProduct(Product product) {
        Product product1=productRepository.findById(product.getProductId()).orElseThrow(()->new ResourceNotFoundException("ID NotExists"));
        product1.setProductName(product.getProductName());
        product1.setProductCost(product.getProductCost());


        return "Product Updated";
    }

    @Override
    public Product SearchProduct(String productId) {
        Product product1=productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("ID NotExists"));
        return product1;
    }

    @Override
    public List<Product> getALLProducts() {
        List<Product> list=productRepository.findAll();
        return list;
    }

    @Override
    public List<Product> getALLProductsByProductsType(String productType) {
        return productRepository.findByproductType(productType);
    }

    @Override
    public List<Product> getAllProductByRange(String choice,int minPrice, int maxPrice) {
        return productRepository.findProductsByPriceRange(choice,minPrice,maxPrice);
    }

    @Override
    public List<Product> getLatestProducts() {
        return productRepository.findTop10ByOrderByPostedDateDesc();
    }

    @Override
    public int saveImage(MultipartFile image) {
        Images images=new Images();
        try {
            images.setData(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imageRepository.save(images);
        return images.getImgId();
    }
    @Override
    public byte[] findImage(int id) {
        Images images=imageRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("image not exists"));
//
         return Base64.getEncoder().encode(images.getData());

    }


}
