package com.emerline.hubarevich.dao.impl;

import com.emerline.hubarevich.dao.CarDAO;
import com.emerline.hubarevich.dao.CarModelDAO;
import com.emerline.hubarevich.dao.ProducerDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.*;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:eclipselink-test-beans.xml"})
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class})

public class CarDAOImplTest {

    private final Logger LOG = LogManager.getLogger(CarDAOImplTest.class);
    private final int YEAR_INT = 2005;
    private final int MONTH_INT = 1;
    private final int DAY_INT = 1;
    private final LocalDate YEAR = LocalDate.of(YEAR_INT, MONTH_INT, DAY_INT);
    private final Car CAR = new Car(null, 1L, 1L, YEAR, Fuel.diesel, Transmission.automatic);
    private final Car CAR_2 = new Car(null, 1L, 1L, YEAR, Fuel.diesel, Transmission.automatic);
    private final CarModel CAR_MODEL = new CarModel(1L, 1L, "2110");
    private final Producer PRODUCER = new Producer(1L, "Volvo");

    private final Fuel UPD_FUEL = Fuel.gas;

    @Autowired
    CarDAO carDao;
    @Autowired
    CarModelDAO carModelDao;
    @Autowired
    ProducerDAO producerDao;

    @Test
    @DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
    public void findAll() {
        try {
            assertEquals(3, carDao.findAll().size());
        } catch (DaoException e) {
            LOG.error(e);
        }
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
    public void findDomainById() {
        try {
            assertEquals((Long)1L,
                    carDao.findDomainById(1L).getProducerId());
        } catch (DaoException e) {
            LOG.error(e);
        }
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
    public void delete() {
        try {
            carDao.delete(1L);
            assertEquals(2, carDao.findAll().size());
        } catch (DaoException e) {
            LOG.error(e);
        }
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
    public void create() throws DaoException{
            carDao.create(CAR);
            assertEquals(4,carDao.findAll().size());
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
    public void update() {
        Car car;
        try {
            car = carDao.findDomainById(1L);
            car.setFuel(UPD_FUEL);
            carDao.update(car);
            assertEquals(UPD_FUEL, carDao.findDomainById(1L).getFuel());
        } catch (DaoException e) {
            LOG.error(e);
        }
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
    public void getCarsByProducer() {
        List<Car> cars = new ArrayList<>();
        try {
            cars.addAll(carDao.getCarsByProducer(1L));
            assertEquals(1, cars.size());
        } catch (DaoException e) {
            LOG.error(e);
        }
    }

    @Test
    @DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
    @DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
    public void getCarsByModel() {
        List<Car> cars = new ArrayList<>();
        try {
            cars.addAll(carDao.getCarsByModel(1L));
            assertEquals(1, cars.size());
        } catch (DaoException e) {
            LOG.error(e);
        }
    }

}
