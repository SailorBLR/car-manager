package com.emerline.hubarevich.business.impl;

import com.emerline.hubarevich.business.CarService;
import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.dao.CarDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Car;
import com.emerline.hubarevich.util.CarCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDAO carDao;

	@Override
	public Long createCar(Car car) throws LogicException {
		Long backId = 0L;
        try {
			if (CarCheckUtil.checkCar(car)) {
				backId = carDao.create(car);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return backId;
	}

	@Override
	public void deleteCar(Long carId) throws LogicException {
		try {
            if (carId != null) {
				carDao.delete(carId);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void updateCar(Car car) throws LogicException {
		try {
			if (CarCheckUtil.checkCar(car)) {
				carDao.update(car);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}

	}

	@Override
	public List<Car> getListOfCars() throws LogicException {
		List<Car> cars = new ArrayList<>();
		try {
			cars.addAll(carDao.findAll());
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return cars;
	}

	@Override
	public Car getCarById(Long carId) throws LogicException {
		Car car = null;
		try {
			if (carId != null && carId > 0L) {
				car = carDao.findDomainById(carId);
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return car;
	}

	@Override
	public List<Car> getListOfCarsByModel(Long modelId) throws LogicException {
		List<Car> cars = new ArrayList<>();
		try {
			if (modelId != null){
				cars.addAll(carDao.getCarsByModel(modelId));
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return cars;
	}

	@Override
	public List<Car> getListOfCarsByProducer(Long producerId) throws LogicException {
		List<Car> cars = new ArrayList<>();
		try {
			if (producerId != null){
				cars.addAll(carDao.getCarsByProducer(producerId));
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return cars;
	}

}
