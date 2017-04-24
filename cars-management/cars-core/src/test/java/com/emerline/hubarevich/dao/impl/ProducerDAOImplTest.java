package com.emerline.hubarevich.dao.impl;

import com.emerline.hubarevich.dao.ProducerDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Producer;
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

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:eclipselink-test-beans.xml" })
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class,
		TransactionalTestExecutionListener.class })

public class ProducerDAOImplTest {

	private final Logger LOG = LogManager.getLogger(ProducerDAOImplTest.class);
	private final Producer PRODUCER = new Producer(1L, "Volvo");
	private final String UPD_NAME = "Kia";

	@Autowired
	ProducerDAO producerDAO;

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void findAll() {
		try {
			assertEquals(3, producerDAO.findAll().size());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	public void findDomainById() {
		try {
			assertEquals(producerDAO.create(PRODUCER),
					producerDAO.findDomainById(PRODUCER.getProducerId()).getProducerId());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void delete() {
		try {
			producerDAO.delete(1L);
			assertEquals(2, producerDAO.findAll().size());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	public void create() {
		try {
			assertEquals(PRODUCER.getProducerId(), producerDAO.create(PRODUCER));
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void update() {
		Producer producer;
		try {
			producer = producerDAO.findDomainById(1L);
			producer.setProducerName(UPD_NAME);
			producerDAO.update(producer);
			assertEquals(UPD_NAME, producerDAO.findDomainById(1L).getProducerName());
		} catch (DaoException e) {
			LOG.error(e);
		}
	}
	
	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void getProducerByCarId() {
		try {
			assertEquals(producerDAO.findDomainById(1L),producerDAO.getProducerByCarId(1L));
		} catch (DaoException e) {
			LOG.error(e);
		}
	}
	
	@Test
	@DatabaseSetup(value = "classpath:dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value = "classpath:dataset.xml", type = DatabaseOperation.DELETE_ALL)
	public void getProducerByModelId() {
		try {
			assertEquals(producerDAO.findDomainById(1L),producerDAO.getProducerByModelId(1L));
		} catch (DaoException e) {
			LOG.error(e);
		}
	}

}
