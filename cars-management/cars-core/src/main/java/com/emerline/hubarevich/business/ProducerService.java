package com.emerline.hubarevich.business;

import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.domain.Producer;

import java.util.List;

public interface ProducerService {
	/**
     * Creates Producer object
     * @param producer Producer instance
     * @return Producer identifier
     * @throws LogicException if DaoException obtained
     */
    Long createProducer(Producer producer) throws LogicException;

    /**
     * Deletes field from database
     * @param producerId Long value
     * @throws LogicException if DAOException obtained
     */
    void deleteProducer(Long producerId) throws LogicException;
    
    /**
     * Updates field in database with input object
     * @param producer Producer instance
     * @throws LogicException if DaoException obtained
     */
    void updateProducer(Producer producer) throws LogicException;
    
    /**
     * Retrieves collection of all Producers
     * @return List<Producer> List of all producers
     * @throws LogicException if DaoException obtained
     */
    List<Producer> getListOfProducers() throws LogicException;
    
    /**
     * Retrieves Producer object by identifier
     * @param Long identifier
     * @return Producer object
     * @throws LogicException if DaoException obtained
     */
    Producer getProducerById(Long producerId) throws LogicException;
    
    /**
     * Retrieves Producer object by Car identifier
     * @param Long identifier
     * @return Producer object
     * @throws LogicException if DaoException obtained
     */
    Producer getProducerByCar(Long carId) throws LogicException;
    
    /**
     * Retrieves Producer object by Model identifier
     * @param Long identifier
     * @return Producer object
     * @throws LogicException if DaoException obtained
     */
    Producer getProducerByModel(Long modelId) throws LogicException;

}
