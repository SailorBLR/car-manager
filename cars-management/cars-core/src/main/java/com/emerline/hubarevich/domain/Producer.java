package com.emerline.hubarevich.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PRODUCERS")
public class Producer implements Domain {

	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "PROD_SEQ",
            sequenceName = "PRODUCERS_SEQ",
            allocationSize = 50, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "PROD_SEQ")
    @Column(name = "PRODUCER_ID")
	private Long producerId;
	
	@Column(name = "PRODUCER_NAME")
	private String producerName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "producer")
	private Set<Car> cars;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "producer")
	private Set<CarModel> carModels;
	
	
	 
	public Producer() {}
	
	public Producer(Long producerId, String producerName) {
		super();
		this.producerId = producerId;
		this.producerName = producerName;
	}
	public Long getProducerId() {
		return producerId;
	}
	public void setProducerId(Long producerId) {
		this.producerId = producerId;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	
	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Set<CarModel> getCarModels() {
		return carModels;
	}

	public void setCarModels(Set<CarModel> carModels) {
		this.carModels = carModels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((producerId == null) ? 0 : producerId.hashCode());
		result = prime * result + ((producerName == null) ? 0 : producerName.hashCode());
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
		Producer other = (Producer) obj;
		if (producerId == null) {
			if (other.producerId != null)
				return false;
		} else if (!producerId.equals(other.producerId))
			return false;
		if (producerName == null) {
			if (other.producerName != null)
				return false;
		} else if (!producerName.equals(other.producerName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Producer [producerId=" + producerId + ", producerName=" + producerName + "]";
	}
	
	
	
	

}
