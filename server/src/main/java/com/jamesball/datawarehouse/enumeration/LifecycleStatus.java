package com.jamesball.datawarehouse.enumeration;

public enum LifecycleStatus {

    PROPOSED(0x1c21L),
    SCOPED(0x1c22L),
    EXECUTION_READY(0x1c23L),
    ACTIVE(0x1c24L),
    COMPLETED(0x1c25L),
    CANCELLED(0x1c26L),
    SUSPENDED(0x1c27L);

    private Long id;

    LifecycleStatus(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
