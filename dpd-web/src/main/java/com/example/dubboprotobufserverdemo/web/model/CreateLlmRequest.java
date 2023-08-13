package com.example.dubboprotobufserverdemo.web.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateLlmRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    private String company;

    private boolean isOpenSource;

}
