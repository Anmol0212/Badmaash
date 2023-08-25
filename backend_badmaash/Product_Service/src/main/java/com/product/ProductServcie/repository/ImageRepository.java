package com.product.ProductServcie.repository;

import com.product.ProductServcie.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Images,Integer> {
}
