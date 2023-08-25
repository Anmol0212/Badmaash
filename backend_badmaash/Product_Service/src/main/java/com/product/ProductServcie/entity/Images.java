package com.product.ProductServcie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imgId;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

}
