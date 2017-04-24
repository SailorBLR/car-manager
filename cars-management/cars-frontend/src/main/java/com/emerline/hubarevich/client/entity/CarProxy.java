package com.emerline.hubarevich.client.entity;

/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
public class CarProxy {
    private Long modelId;
    private Long producerId;
    private Long produceYear;
    private String fuel;
    private String transmission;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public Long getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(Long produceYear) {
        this.produceYear = produceYear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
