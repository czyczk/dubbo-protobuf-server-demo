package com.example.dubboprotobufserverdemo.util.converter;

import com.example.dubboprotobufserverdemo.facade.Llm;

public class LlmConverter {

    public static Llm toProtobufLlm(com.example.dubboprotobufserverdemo.common.model.Llm domainModel) {
        Llm protobufModel = Llm.newBuilder()
                .setId(domainModel.getId())
                .setName(domainModel.getName())
                .setCompany(domainModel.getCompany())
                .setIsOpenSource(domainModel.isOpenSource())
                .build();
        return protobufModel;
    }

    public static com.example.dubboprotobufserverdemo.common.model.Llm toDomainLlm(Llm protobufModel) {
        com.example.dubboprotobufserverdemo.common.model.Llm domainModel = com.example.dubboprotobufserverdemo.common.model.Llm
                .builder()
                .id(protobufModel.getId())
                .name(protobufModel.getName())
                .company(protobufModel.getCompany())
                .isOpenSource(protobufModel.getIsOpenSource())
                .build();
        return domainModel;
    }

}
