package com.emerline.hubarevich.DTOmodels;

import com.emerline.hubarevich.domain.*;

import java.time.LocalDate;

public class CarObjectDTO {
	
	private Long carId;
    private Long modelId;
    private Long producerId;

    private LocalDate produceYear;
    private Fuel fuel;
    private Transmission transmission;

    private String modelName;
    private String producerName;


	public Long getCarId() {
	    return carId;
	}

    public void setCarId(Long carId) {
        this.carId = carId;
    }

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

    public LocalDate getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(LocalDate produceYear) {
        this.produceYear = produceYear;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public void setCar(Car car) {
	    this.carId = car.getCarId();
	    this.modelId = car.getModelId();
	    this.producerId = car.getProducerId();
	    this.produceYear = car.getProduceYear();
	    this.fuel = car.getFuel();
	    this.transmission = car.getTransmission();
    }

    public void setModel(CarModel carModel) {
	    this.modelName = carModel.getModelName();
    }

    public CarModel getCarModel() {
	    return new CarModel(this.modelId, this.producerId, this.modelName);
    }

    public void setProducer(Producer producer) {
	    this.producerName = producer.getProducerName();
    }

    public Producer getProducer() {
	    return new Producer(this.producerId, this.producerName);
    }

    @Override
    public String toString() {
        return "CarObjectDTO{" +
                "carId=" + carId +
                ", modelId=" + modelId +
                ", producerId=" + producerId +
                ", produceYear=" + produceYear +
                ", fuel=" + fuel +
                ", transmission=" + transmission +
                ", modelName='" + modelName + '\'' +
                ", producerName='" + producerName + '\'' +
                '}';
    }
}
