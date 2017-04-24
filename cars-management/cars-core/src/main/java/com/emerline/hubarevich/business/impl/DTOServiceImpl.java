package com.emerline.hubarevich.business.impl;

import com.emerline.hubarevich.DTOmodels.CarObjectDTO;
import com.emerline.hubarevich.business.CarModelService;
import com.emerline.hubarevich.business.CarService;
import com.emerline.hubarevich.business.DTOService;
import com.emerline.hubarevich.business.ProducerService;
import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Car;
import com.emerline.hubarevich.util.CheckDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOServiceImpl implements DTOService {
	
	@Autowired
	private CarService carService;
	@Autowired
	private CarModelService modelService;
	@Autowired
	private ProducerService producerService;

	@Override
	public CarObjectDTO getCarDTO(Long carId) throws LogicException {
		CarObjectDTO dto = new CarObjectDTO();
		dto.setCar(carService.getCarById(carId));
		dto.setModel(modelService.getCarModelByCar(carId));
		dto.setProducer(producerService.getProducerByCar(carId));
		
		return CheckDtoUtil.checkDto(dto) ? dto : null;
	}

	@Override
	public List<CarObjectDTO> getListOfDtos() throws LogicException {
		List<Car> cars = new ArrayList<>();
		List<CarObjectDTO> listDtos = new ArrayList<>();
		cars.addAll(carService.getListOfCars());
		for (Car car : cars) {
			listDtos.add(getCarDTO(car.getCarId()));
		}
		return listDtos;
	}


}
