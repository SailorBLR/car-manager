package com.emerline.hubarevich.business;

import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.domain.Car;

import java.util.List;

public interface CarService {

	/**
     * Creates Car object
     * @param car Car instance
     * @return Car identifier
     * @throws LogicException if DaoException obtained
     */
    Long createCar(Car car) throws LogicException;

    /**
     * Deletes field from database
     * @param carId Long value
     * @throws LogicException if DAOException obtained
     */
    void deleteCar(Long carId) throws LogicException;
    
    /**
     * Updates field in database with input object
     * @param car Car instance
     * @throws LogicException if DaoException obtained
     */
    void updateCar(Car car) throws LogicException;
    
    /**
     * Retrieves collection of all Cars
     * @return List<Car> List of all cars
     * @throws LogicException if DaoException obtained
     */
    List<Car> getListOfCars() throws LogicException;
    
    /**
     * Retrieves Car object by identifier
     * @param Long identifier
     * @return Car object
     * @throws LogicException if DaoException obtained
     */
    Car getCarById(Long carId) throws LogicException;
    
    /**
     * Retrieves collection of all Cars according to model
     * @return List<Car> List of all cars by model
     * @throws LogicException if DaoException obtained
     */
    List<Car> getListOfCarsByModel(Long modelId) throws LogicException;
    
    /**
     * Retrieves collection of all Cars according to Producer
     * @return List<Car> List of all cars by producer
     * @throws LogicException if DaoException obtained
     */
    List<Car> getListOfCarsByProducer(Long producerId) throws LogicException;
}
