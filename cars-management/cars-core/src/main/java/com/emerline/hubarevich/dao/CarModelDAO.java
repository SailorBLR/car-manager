/**Created by Anton*/
package com.emerline.hubarevich.dao;

import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.CarModel;

import java.util.List;

public interface CarModelDAO extends AbstractDAO<CarModel>{
	
	/**
	 * Returns the list of models from particular Producer
	 * */
	List<CarModel> getModelsByProducer (Long producerId) throws DaoException; 
	
	/**
	 * Returns CarModel according to the Car identifier
	 */
	CarModel getModelByCar(Long carId) throws DaoException;

}
