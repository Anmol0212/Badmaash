package com.product.ProductServcie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  productId;
    private String productType;
    private String productName;
    private int productCost;
    private String sellerId;
    private LocalDateTime postedDate;
    private String imageLink;
//    @Lob
//    @Column(columnDefinition = "BLOB")
//    private byte[] data;
}
