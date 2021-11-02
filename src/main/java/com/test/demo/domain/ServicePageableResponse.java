package com.test.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicePageableResponse<T>{

    private T response;
    private boolean success ;
    private String serviceOrigin;
}
