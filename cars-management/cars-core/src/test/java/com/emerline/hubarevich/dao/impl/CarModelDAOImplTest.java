package com.emerline.hubarevich.dao.impl;

import com.emerline.hubarevich.dao.CarModelDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.CarModel;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:eclipselink-test-beans.xml" })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class,
		TransactionalTestExecutionListener.class })

public class CarModelDAOImplTest {
	private final Logger LOG = LogManager.getLogger(CarModelDAOImplTest.class);
	private final CarModel CAR_MODEL = new CarModel(4L, 1L, "2110");
	private final String UPD_MODEL_NAME = "2113";

	@Autowired
	CarModelDAO carModelDao;

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void findAll() {
		try {
			assertEquals(3, carModelDao.findAll().size());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void findDomainById() {
		try {
			assertEquals(carModelDao.create(CAR_MODEL),
					carModelDao.findDomainById(CAR_MODEL.getModelId()).getModelId());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void delete() {
		try {
			carModelDao.delete(1L);
			assertEquals(2, carModelDao.findAll().size());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void create() {
		try {
			assertEquals(CAR_MODEL.getModelId(), carModelDao.create(CAR_MODEL));
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void update() {
		CarModel carModel;
		try {
			carModel = carModelDao.findDomainById(1L);
			carModel.setModelName(UPD_MODEL_NAME);
			carModelDao.update(carModel);
			assertEquals(UPD_MODEL_NAME, carModelDao.findDomainById(1L).getModelName());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void getModelsByProducer() {

		try {
			assertEquals(1, carModelDao.getModelsByProducer(1L).size());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}
	
	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void getModelByCar() {
		try {
			assertEquals((Long)1L, carModelDao.getModelByCar(1L).getModelId());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

}
