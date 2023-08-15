package com.example.dubboprotobufserverdemo.service.dubbo.impl;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dubboprotobufserverdemo.common.model.Llm;
import com.example.dubboprotobufserverdemo.facade.DpdFacade;
import com.example.dubboprotobufserverdemo.service.llm.LlmService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    public StreamObserver<Integer> sumStream(StreamObserver<Integer> response) {
        AtomicInteger sum = new AtomicInteger(0);

        return new StreamObserver<Integer>() {
            @Override
            public void onNext(Integer data) {
                log.info("request onNext: {}", data);
                if (data == null) {
                    return;
                }
                sum.addAndGet(data);
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("request onError: {}", throwable.getMessage());
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                log.info("request onCompleted");
                response.onNext(sum.get());
                response.onCompleted();
            }
        };
    }

    @Override
    public void throwException() {
        log.info("throwException");
        throw new RuntimeException("Exception from DpdFacadeImpl");
    }

}
