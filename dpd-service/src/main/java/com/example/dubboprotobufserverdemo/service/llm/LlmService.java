package com.example.dubboprotobufserverdemo.service.llm;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.dubboprotobufserverdemo.common.model.Llm;

@Service
public class LlmService {

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

    public void createLlm(Llm llm) {
        llmMap.put(llm.getId(), llm);
    }

    public Llm getLlm(String id) {
        return llmMap.get(id);
    }

}
