package com.example.dubboprotobufserverdemo.web.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dubboprotobufserverdemo.common.model.Llm;
import com.example.dubboprotobufserverdemo.service.llm.LlmService;
import com.example.dubboprotobufserverdemo.web.model.CreateLlmRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/llm")
public class LlmController {

    @Autowired
    private LlmService llmService;

    @PostMapping
    public void createLlm(@RequestBody @Valid CreateLlmRequest request) {
        log.info("createLlm: {}", request);
        Llm llm = new Llm();
        llm.setId(request.getId());
        llm.setName(request.getName());
        llm.setCompany(request.getCompany());
        llm.setOpenSource(request.isOpenSource());

        llmService.createLlm(llm);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Llm getLlm(@PathVariable @NotBlank String id) {
        log.info("getLlm: {}", id);
        return llmService.getLlm(id);
    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        log.info("ping");
        return "pong";
    }
}
