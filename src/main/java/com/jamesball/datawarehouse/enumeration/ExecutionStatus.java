package com.jamesball.datawarehouse.enumeration;

public enum ExecutionStatus {
    RUNNING(0x1781L),
    COMPLETED(0x1782L),
    FAILED(0x1783L),
    NOT_STARTED(0x1784L);

    private Long id;

    ExecutionStatus(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}