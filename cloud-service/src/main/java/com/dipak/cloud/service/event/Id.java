package com.dipak.cloud.service.event;

import java.util.UUID;

public class Id {

    private UUID id;

    public Id() {
        this.id = UUID.randomUUID();
    }

    public Id(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id{" +
                "id=" + id +
                '}';
    }
}
