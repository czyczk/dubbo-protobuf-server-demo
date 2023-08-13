package com.example.dubboprotobufserverdemo.facade;

import com.example.dubboprotobufserverdemo.common.model.Llm;

/**
 * DPD Protobuf-styled facade.
 */
public interface DpdProtobufFacade {

    /**
     * Ping
     * 
     * @return "pong"
     */
    PingResponse ping();

    /**
     * Get an {@link Llm}.
     * 
     * @param id
     * @return
     */
    GetLlmResponse getLlm(GetLlmRequest getLlmRequest);

    /**
     * Creates an {@link Llm}.
     * 
     * @param llm
     */
    void createLlm(CreateLlmRequest createLlmRequest);

    /**
     * Throws an exception.
     */
    void throwException();

}
