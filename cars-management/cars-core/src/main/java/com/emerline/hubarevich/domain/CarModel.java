package com.emerline.hubarevich.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "MODELS")
public class CarModel implements Domain {

	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "MODEL_SEQ",
            sequenceName = "MODEL_SEQ",
            allocationSize = 500)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MODEL_SEQ")
    @Column(name = "MODEL_ID")
	private Long modelId;
	
	@Column(name = "PRODUCER_ID")
	private Long producerId;
	
	@Column(name = "MODEL_NAME")
	private String modelName;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCER_ID", insertable=false, updatable=false)
    private Producer producer;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carModel")
	private Set<Car> cars;
	

	public CarModel(){};
	
	public CarModel(Long modelId, Long producerId, String modelName) {
		super();
		this.modelId = modelId;
		this.producerId = producerId;
		this.modelName = modelName;
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

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + ((producerId == null) ? 0 : producerId.hashCode());
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
		CarModel other = (CarModel) obj;
		if (modelId == null) {
			if (other.modelId != null)
				return false;
		} else if (!modelId.equals(other.modelId))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (producerId == null) {
			if (other.producerId != null)
				return false;
		} else if (!producerId.equals(other.producerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Model [modelId=" + modelId + ", producerId=" + producerId + ", modelName=" + modelName + "]";
	}
	
	

	
}
