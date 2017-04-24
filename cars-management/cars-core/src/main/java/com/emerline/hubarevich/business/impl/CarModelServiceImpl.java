package com.emerline.hubarevich.business.impl;

import com.emerline.hubarevich.business.CarModelService;
import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.dao.CarModelDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.CarModel;
import com.emerline.hubarevich.util.CarModelCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarModelServiceImpl implements CarModelService {

	@Autowired
	private CarModelDAO carModelDao;

	@Override
	public Long createCarModel(CarModel carModel) throws LogicException {
		Long backId = 0L;
		try {
			if (CarModelCheckUtil.checkCarModel(carModel)) {
				backId = carModelDao.create(carModel);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return backId;
	}

	@Override
	public void deleteCarModel(Long carModelId) throws LogicException {
		try {
			if (carModelId != null) {
				carModelDao.delete(carModelId);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void updateCarModel(CarModel carModel) throws LogicException {
		try {
			if (CarModelCheckUtil.checkCarModel(carModel)) {
				carModelDao.update(carModel);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}

	}

	@Override
	public List<CarModel> getListOfCarModels() throws LogicException {
		List<CarModel> carModels = new ArrayList<>();
		try {
			carModels.addAll(carModelDao.findAll());
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return carModels;
	}

	@Override
	public CarModel getCarModelById(Long carModelId) throws LogicException {
		CarModel carModel = null;
		try {
			if (carModelId != null && carModelId > 0L) {
				carModel = carModelDao.findDomainById(carModelId);
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return carModel;
	}

	@Override
	public List<CarModel> getListOfCarModelsByProducer(Long producerId) throws LogicException {
		List<CarModel> carModels = null;
		try {
			if(producerId != null && producerId > 0L) {
				carModels = carModelDao.getModelsByProducer(producerId);
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return carModels;
	}

	@Override
	public CarModel getCarModelByCar(Long carId) throws LogicException {
		CarModel carModel = null;
		try {
			if(carId != null && carId > 0L) {
				carModel = carModelDao.getModelByCar(carId);
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return carModel;
	}

}
