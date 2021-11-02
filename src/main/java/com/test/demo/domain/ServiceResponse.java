package com.test.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse <T>{

    private T response;
    private boolean success ;
    private String serviceOrigin;
}
