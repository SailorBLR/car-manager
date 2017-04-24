package com.emerline.hubarevich.dao;

import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Producer;

public interface ProducerDAO extends AbstractDAO<Producer> {
	
	Producer getProducerByCarId(Long carId) throws DaoException;
	Producer getProducerByModelId(Long modelId) throws DaoException;

}
