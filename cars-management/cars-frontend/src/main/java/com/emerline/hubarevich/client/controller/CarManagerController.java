package com.emerline.hubarevich.client.controller;

import com.emerline.hubarevich.DTOmodels.CarObjectDTO;
import com.emerline.hubarevich.business.CarModelService;
import com.emerline.hubarevich.business.CarService;
import com.emerline.hubarevich.business.DTOService;
import com.emerline.hubarevich.business.ProducerService;
import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.client.entity.CarModelProxy;
import com.emerline.hubarevich.client.entity.CarProxy;
import com.emerline.hubarevich.client.entity.ProducerProxy;
import com.emerline.hubarevich.domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
public class CarManagerController {

    private final Logger LOG = LogManager.getLogger(CarManagerController.class);
    @Autowired
    private CarService carService;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private DTOService dtoService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<CarObjectDTO> getAllCars() {
        List<CarObjectDTO> cars = null;
        try {
            cars = dtoService.getListOfDtos();
        } catch (LogicException e) {
           LOG.error(e);
        }
        return cars;
    }

    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public CarObjectDTO getCar(@PathVariable Long carId) {
        CarObjectDTO carObjectDTO = null;
        try {
            carObjectDTO = dtoService.getCarDTO(carId);
        } catch (LogicException e) {
            LOG.error(e);
        }
        return carObjectDTO;
    }

    @RequestMapping(value = "/producers", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<ProducerProxy> getAllProducers() {
        List<ProducerProxy> producers = new ArrayList<>();
        try {
            for (Producer producer : producerService.getListOfProducers()) {
                producers.add(new ProducerProxy(producer));
            }
        } catch (LogicException e) {
            LOG.error(e);
        }
        return producers;
    }

    @RequestMapping(value = "/producers/{producerId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ProducerProxy getProducer(@PathVariable Long producerId) {
        ProducerProxy producer = null;
        try {
            producer = new ProducerProxy(producerService.getProducerById(producerId));
        } catch (LogicException e) {
            LOG.error(e);
        }
        return producer;
    }

    @RequestMapping(value = "/models", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<CarModelProxy> getAllModels() {
        List<CarModelProxy> models = new ArrayList<>();
        try {
            for (CarModel carModel : carModelService.getListOfCarModels()) {
                models.add(new CarModelProxy(carModel));
            }
        } catch (LogicException e) {
            LOG.error(e);
        }
        return models;
    }

    @RequestMapping(value = "/models/{modelId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public CarModelProxy getModel(@PathVariable Long modelId) {
        CarModelProxy model = null;
        try {
            model = new CarModelProxy(carModelService.getCarModelById(modelId));
        } catch (LogicException e) {
            LOG.error(e);
        }
        return model;
    }

    @RequestMapping(value = "/models/producerId/{producerId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<CarModelProxy> getModelByProducer(@PathVariable Long producerId) {
        List<CarModelProxy> models = new ArrayList<>();
        List<CarModel> carModels = null;
        try {
            carModels = carModelService.getListOfCarModelsByProducer(producerId);
            if (carModels != null) {
                for (CarModel carModel : carModelService.getListOfCarModelsByProducer(producerId)) {
                    models.add(new CarModelProxy(carModel));
                }
            }
        } catch (LogicException e) {
            LOG.error(e);
        }
        return models;
    }

    @RequestMapping(value = "/create/insert", method = RequestMethod.POST)
    public void createCar(@RequestBody CarProxy car) throws IOException {
        LocalDate date =
                Instant.ofEpochMilli(car.getProduceYear()).atZone(ZoneId.systemDefault()).toLocalDate();
        try {
            Car carInstance = new Car();
            carInstance.setModelId(car.getModelId());
            carInstance.setProducerId(car.getProducerId());
            carInstance.setProduceYear(date);
            carInstance.setFuel(Fuel.valueOf(car.getFuel()));
            carInstance.setTransmission(Transmission.valueOf(car.getTransmission()));
            carService.createCar(carInstance);
        } catch (LogicException e) {
            LOG.error(e);
        }
    }

    @RequestMapping(value = "/deleteCar/{carId}",
            method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable Long carId) throws ParseException {
        try {
            carService.deleteCar(carId);
        } catch (LogicException e) {
            LOG.error(e);
        }
    }
}