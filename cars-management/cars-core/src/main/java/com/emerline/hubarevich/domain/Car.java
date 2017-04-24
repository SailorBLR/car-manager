package com.emerline.hubarevich.domain;

import com.emerline.hubarevich.util.LocalDateAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


@Entity
@Table(name = "CARS")
public class Car implements Domain {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "CAR_SEQ",
            sequenceName = "CAR_SEQ",
            allocationSize = 500)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CAR_SEQ")
    @Column(name = "CAR_ID")
	private Long carId;
	
	@Column(name = "PRODUCER_ID")
	private Long producerId;
	
	@Column(name = "MODEL_ID")
	private Long modelId;
	
	@Column(name = "PRODUCTION_YEAR")
	private LocalDate produceYear;
	
	@Column(name = "FUEL")
	private Fuel fuel;
	
	@Column(name = "TRANSMISSION")
	private Transmission transmission;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCER_ID", insertable=false, updatable=false)
	private Producer producer;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MODEL_ID", insertable=false, updatable=false)
	private CarModel carModel;

	public Car() {
	}
	
	public Car(Long carId, Long producerId, Long modelId, LocalDate produceYear, Fuel fuel,
			Transmission transmission) {
		super();
		this.carId = carId;
		this.producerId = producerId;
		this.modelId = modelId;
		this.produceYear = produceYear;
		this.fuel = fuel;
		this.transmission = transmission;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public Long getProducerId() {
		return producerId;
	}
	public void setProducerId(Long producerId) {
		this.producerId = producerId;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
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
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
		result = prime * result + ((produceYear == null) ? 0 : produceYear.hashCode());
		result = prime * result + ((producerId == null) ? 0 : producerId.hashCode());
		result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (fuel != other.fuel)
			return false;
		if (modelId == null) {
			if (other.modelId != null)
				return false;
		} else if (!modelId.equals(other.modelId))
			return false;
		if (produceYear == null) {
			if (other.produceYear != null)
				return false;
		} else if (!produceYear.equals(other.produceYear))
			return false;
		if (producerId == null) {
			if (other.producerId != null)
				return false;
		} else if (!producerId.equals(other.producerId))
			return false;
		if (transmission != other.transmission)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", producerId=" + producerId + ", modelId=" + modelId + ", produceYear="
				+ produceYear + ", fuel=" + fuel + ", transmission=" + transmission + "]";
	}
	
	

}
