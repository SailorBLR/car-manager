package com.emerline.hubarevich.business;

import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.domain.CarModel;

import java.util.List;

public interface CarModelService {

	/**
     * Creates CarModel object
     * @param carModel CarModel instance
     * @return CarModel identifier
     * @throws LogicException if DaoException obtained
     */
    Long createCarModel(CarModel carModel) throws LogicException;

    /**
     * Deletes field from database
     * @param carModelId Long value
     * @throws LogicException if DAOException obtained
     */
    void deleteCarModel(Long carModelId) throws LogicException;
    
    /**
     * Updates field in database with input object
     * @param carModel CarModel instance
     * @throws LogicException if DaoException obtained
     */
    void updateCarModel(CarModel carModel) throws LogicException;
    
    /**
     * Retrieves collection of all CarModels
     * @return List<CarModel> List of all carModels
     * @throws LogicException if DaoException obtained
     */
    List<CarModel> getListOfCarModels() throws LogicException;
    
    /**
     * Retrieves CarModel object by identifier
     * @param Long identifier
     * @return CarModel object
     * @throws LogicException if DaoException obtained
     */
    CarModel getCarModelById(Long carModelId) throws LogicException;
    
    /**
     * Retrieves collection of all CarModels according to Producer
     * @return List<CarModel> List of all carModels by producer
     * @throws LogicException if DaoException obtained
     */
    List<CarModel> getListOfCarModelsByProducer(Long producerId) throws LogicException;
    
    /**
     * Retrieves CarModel by Car
     * @return CarModel object
     * @throws LogicException if DaoException obtained
     */
    CarModel getCarModelByCar(Long carId) throws LogicException;
}
