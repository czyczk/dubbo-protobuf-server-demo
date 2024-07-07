package com.example.dubboprotobufserverdemo.service.dubbo.impl;

import java.util.concurrent.CompletableFuture;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dubboprotobufserverdemo.common.model.Llm;
import com.example.dubboprotobufserverdemo.facade.DpdAsyncFacade;
import com.example.dubboprotobufserverdemo.service.llm.LlmReactiveService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@DubboService(version = "${dubbo-service-version.protobuf-server-demo}", validation = "true", protocol = "tri")
public class DpdAsyncFacadeImpl implements DpdAsyncFacade {

    @Autowired
    private LlmReactiveService llmReactiveService;

    @Override
    public CompletableFuture<String> ping() {
        log.info("ping");
        return Mono.just("pong").toFuture();
    }

    @Override
    public CompletableFuture<Llm> getLlm(String id) {
        log.info("getLlm: {}", id);
        return llmReactiveService.getLlm(id).toFuture();
    }

    @Override
    public CompletableFuture<Llm> getLlmTimeConsuming(String id, long duration) {
        log.info("getLlmTimeConsuming: {}, {}", id, duration);
        return llmReactiveService.getLlmTimeConsuming(id, duration).toFuture();
    }

    @Override
    public CompletableFuture<Void> createLlm(Llm llm) {
        log.info("createLlm: {}", llm);
        return llmReactiveService.createLlm(llm).toFuture();
    }

    @Override
    public CompletableFuture<Void> throwException() {
        log.info("throwException");
        return CompletableFuture.failedFuture(new RuntimeException("Exception from DpdReactiveFacadeImpl"));
    }

}
