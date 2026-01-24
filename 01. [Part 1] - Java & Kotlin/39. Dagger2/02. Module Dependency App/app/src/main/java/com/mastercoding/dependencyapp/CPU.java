package com.mastercoding.dependencyapp;

import javax.inject.Inject;

public class CPU {

    Processor processor;

    @Inject
    public CPU(Processor processor) {
        this.processor = processor;
    }

}
