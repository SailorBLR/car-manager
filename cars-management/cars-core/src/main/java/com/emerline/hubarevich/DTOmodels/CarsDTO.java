package com.emerline.hubarevich.DTOmodels;

import com.emerline.hubarevich.domain.Car;
import com.emerline.hubarevich.domain.CarModel;
import com.emerline.hubarevich.domain.Producer;

import java.util.List;

public class CarsDTO {
	
	private List <Car> cars;
	private List <Producer> producers;
	private List <CarModel> model;
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public List<Producer> getProducers() {
		return producers;
	}
	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}
	public List<CarModel> getModel() {
		return model;
	}
	public void setModel(List<CarModel> model) {
		this.model = model;
	}
	
	
	

}
