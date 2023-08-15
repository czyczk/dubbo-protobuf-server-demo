package com.example.dubboprotobufserverdemo.facade;

import java.util.List;

import com.example.dubboprotobufserverdemo.common.model.Llm;
import org.apache.dubbo.common.stream.StreamObserver;

/**
 * DPD POJO-styled facade.
 */
public interface DpdFacade {

    /**
     * Ping
     * 
     * @return "pong"
     */
    String ping();

    /**
     * Get an {@link Llm}.
     * 
     * @param id
     * @return
     */
    Llm getLlm(String id);

    /**
     * Creates an {@link Llm}.
     * 
     * @param llm
     */
    void createLlm(Llm llm);

    /**
     * Accepts a stream of integers and returns the sum;
     * @return
     */
    StreamObserver<Integer> sumStream(StreamObserver<Integer> response);

    /**
     * Throws an exception.
     */
    void throwException();

}
