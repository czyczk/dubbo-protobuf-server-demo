package com.example.dubboprotobufserverdemo.service.llm;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.dubboprotobufserverdemo.common.model.Llm;

import reactor.core.publisher.Mono;

@Service
public class LlmReactiveService {

    // A map for minimalist demo
    private Map<String, Llm> llmMap = new HashMap<>();

    @PostConstruct
    public void init() {
        Llm llm = new Llm();
        llm.setId("chatgpt");
        llm.setName("ChatGPT");
        llm.setCompany("OpenAI");
        llm.setOpenSource(false);
        llmMap.put(llm.getId(), llm);
    }

    public Mono<Void> createLlm(Llm llm) {
        llmMap.put(llm.getId(), llm);
        return Mono.empty();
    }

    public Mono<Llm> getLlm(String id) {
        return Mono.just(llmMap.get(id));
    }

    public Mono<Llm> getLlmTimeConsuming(String id, long duration) {
        return Mono.delay(Duration.ofMillis(duration))
                .map(_tick -> llmMap.get(id));
    }

}
