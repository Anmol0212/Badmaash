package com.product.ProductServcie.payload;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.swing.text.StyledEditorKit;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

}
