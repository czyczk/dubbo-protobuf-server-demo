package com.example.dubboprotobufserverdemo.common.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Llm implements Serializable {

    private String id;

    private String name;

    private String company;

    private boolean isOpenSource;

}
