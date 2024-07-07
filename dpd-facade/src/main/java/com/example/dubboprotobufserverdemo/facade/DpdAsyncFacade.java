package com.example.dubboprotobufserverdemo.facade;

import java.util.concurrent.CompletableFuture;

import com.example.dubboprotobufserverdemo.common.model.Llm;

/**
 * DPD POJO-styled Reactor non-blocking facade.
 */
public interface DpdAsyncFacade {

    /**
     * Ping
     * 
     * @return "pong"
     */
    CompletableFuture<String> ping();

    /**
     * Get an {@link Llm}.
     * 
     * @param id
     * @return
     */
    CompletableFuture<Llm> getLlm(String id);

    /**
     * Get an {@link Llm}, but time-consuming.
     * 
     * @param id
     * @param duration
     * @return
     */
    CompletableFuture<Llm> getLlmTimeConsuming(String id, long duration);

    /**
     * Creates an {@link Llm}.
     * 
     * @param llm
     * @return
     */
    CompletableFuture<Void> createLlm(Llm llm);

    /**
     * Throws an exception.
     * 
     * @return
     */
    CompletableFuture<Void> throwException();

}
