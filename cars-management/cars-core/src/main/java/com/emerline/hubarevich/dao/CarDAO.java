package com.emerline.hubarevich.dao;

import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Car;

import java.util.List;

public interface CarDAO extends AbstractDAO<Car> {
	
	/**
	 * Returns List of Cars according to Producer
	 * @return List<Car>
	 * @param Producer
	 * */
	List <Car> getCarsByProducer(Long producer_id) throws DaoException;
	
	/**
	 * Returns List of Cars according to Model
	 * @return List<Car>
	 * @param CarModel
	 * */
	List <Car> getCarsByModel(Long model_id) throws DaoException;

}
