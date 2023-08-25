package com.product.ProductServcie.repository;

import com.product.ProductServcie.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {


    List<Product> findByproductType(String productType);
    @Query("SELECT p FROM Product p WHERE p.productCost >= :minPrice AND p.productCost <= :maxPrice AND p.productType=:choice")
    List<Product> findProductsByPriceRange( String choice,int minPrice, int maxPrice);
    List<Product> findTop10ByOrderByPostedDateDesc();

}
