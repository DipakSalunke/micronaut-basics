package com.dipak.smart.oven.dto.calibration;

import java.time.LocalDateTime;

public class CalibrationStatus {

    private String modelName;

    private String serialNb;

    private LocalDateTime lastUpdated;

    public CalibrationStatus() { }

    public CalibrationStatus(String modelName, String serialNb, LocalDateTime lastUpdated) {
        this.modelName = modelName;
        this.serialNb = serialNb;
        this.lastUpdated = lastUpdated;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSerialNb() {
        return serialNb;
    }

    public void setSerialNb(String serialNb) {
        this.serialNb = serialNb;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "CalibrationUpdate{" +
                "modelName='" + modelName + '\'' +
                ", serialNb='" + serialNb + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
