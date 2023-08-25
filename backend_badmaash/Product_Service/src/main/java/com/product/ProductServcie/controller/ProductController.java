package com.product.ProductServcie.controller;

import com.product.ProductServcie.entity.Images;
import com.product.ProductServcie.entity.Product;
import com.product.ProductServcie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;



    @GetMapping("/all")
    public ResponseEntity<List<Product>> allProducts()
    {
        List<Product> list=this.productService.getALLProducts();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/allByType/{productType}")
    public ResponseEntity<List<Product>> allProductsByType(@PathVariable String productType)
    {
        List<Product> list=this.productService.getALLProductsByProductsType(productType);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/latest")
    public ResponseEntity<List<Product>> allProductsLatest()
    {
        List<Product> list=this.productService.getLatestProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/range/{choice}/{minRange}/{maxRange}")
    public ResponseEntity<List<Product>> allProductsByRange(@PathVariable String choice,@PathVariable int minRange,@PathVariable int maxRange)
    {
        List<Product> list=this.productService.getAllProductByRange(choice,minRange,maxRange);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> idProduct(@PathVariable String productId)
    {   Product product=this.productService.SearchProduct(productId);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product)
    {
        String msg=this.productService.CreateProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);

    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId)
    {   String msg=this.productService.DeleteProduct(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }
    @PostMapping("/image")
    public int uploadImage(@RequestParam MultipartFile multipartFile)
    {

        return this.productService.saveImage(multipartFile);
    }
    @GetMapping("/image/{id}")
    public byte[] uploadImage(@PathVariable int id)
    {

        return this.productService.findImage(id);
    }







}
