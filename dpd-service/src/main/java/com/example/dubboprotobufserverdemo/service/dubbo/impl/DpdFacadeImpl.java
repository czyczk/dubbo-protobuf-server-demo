package com.example.dubboprotobufserverdemo.service.dubbo.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dubboprotobufserverdemo.common.model.Llm;
import com.example.dubboprotobufserverdemo.facade.DpdFacade;
import com.example.dubboprotobufserverdemo.service.llm.LlmService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService(version = "${dubbo-service-version.protobuf-server-demo}", validation = "true", protocol = "tri")
public class DpdFacadeImpl implements DpdFacade {

    @Autowired
    private LlmService llmService;

    @Override
    public String ping() {
        log.info("ping");
        return "pong";
    }

    @Override
    public Llm getLlm(String id) {
        log.info("getLlm: {}", id);
        return llmService.getLlm(id);
    }

    @Override
    public void createLlm(Llm llm) {
        log.info("createLlm: {}", llm);
        llmService.createLlm(llm);
    }

    @Override
    public void throwException() {
        log.info("throwException");
        throw new RuntimeException("Exception from DpdFacadeImpl");
    }

}
