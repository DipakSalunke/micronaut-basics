package com.dipak.smart.oven.dto.calibration;

public class CalibrationParameters {

    private String model;

    private Integer maxTemp;

    private Integer minTemp;

    public CalibrationParameters() { }

    public CalibrationParameters(String model, Integer maxTemp, Integer minTemp) {
        this.model = model;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Integer maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Integer getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Integer minTemp) {
        this.minTemp = minTemp;
    }

    @Override
    public String toString() {
        return "CalibrationParameters{" +
                "model='" + model + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                '}';
    }
}
