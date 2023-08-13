package com.example.dubboprotobufserverdemo.service.dubbo.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dubboprotobufserverdemo.facade.CreateLlmRequest;
import com.example.dubboprotobufserverdemo.facade.DpdProtobufFacade;
import com.example.dubboprotobufserverdemo.facade.GetLlmRequest;
import com.example.dubboprotobufserverdemo.facade.GetLlmResponse;
import com.example.dubboprotobufserverdemo.facade.PingResponse;
import com.example.dubboprotobufserverdemo.service.llm.LlmService;
import com.example.dubboprotobufserverdemo.util.converter.LlmConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService(version = "${dubbo-service-version.protobuf-server-demo}", validation = "true", protocol = "tri")
public class DpdProtobufFacadeImpl implements DpdProtobufFacade {

    @Autowired
    private LlmService llmService;

    @Override
    public PingResponse ping() {
        log.info("ping");
        return PingResponse.newBuilder().setMsg("pong").build();
    }

    @Override
    public GetLlmResponse getLlm(GetLlmRequest getLlmRequest) {
        log.info("getLlm: {}", getLlmRequest.getId());
        var llm = llmService.getLlm(getLlmRequest.getId());
        return GetLlmResponse.newBuilder()
                .setLlm(LlmConverter.toProtobufLlm(llm))
                .build();
    }

    @Override
    public void createLlm(CreateLlmRequest createLlmRequest) {
        log.info("createLlm: {}", createLlmRequest);
        llmService.createLlm(
                LlmConverter.toDomainLlm(createLlmRequest.getLlm()));
    }

    @Override
    public void throwException() {
        log.info("throwException");
        throw new RuntimeException("Exception from DpdFacadeImpl");
    }

}
