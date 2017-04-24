package com.emerline.hubarevich.dao.impl;

import com.emerline.hubarevich.dao.CarDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Car;
import com.emerline.hubarevich.domain.CarModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {

	private final String CAR_ID = "carId";
	private final String PROD_ID = "producerId";
	private final String MODEL_ID = "modelId";
	private final String QUERY_FIND_ALL = 
			"select C " + 
	        "from Car C";
	private final String QUERY_FIND_BY_CAR_ID = 
			"select C " + 
	        "from Car C  " + 
			"where C.carId = :carId";
	private final String QUERY_FIND_BY_MODEL_ID = 
			"select C " + 
	        "from Car C  " + 
			"where C.modelId = :modelId";
	private final String QUERY_FIND_BY_PRODUCER_ID = 
			"select C " + 
            "from Car C  " +
			"where C.producerId = :producerId";

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Car> findAll() throws DaoException {
		List<Car> cars;
		try {
			cars = entityManager.createQuery(QUERY_FIND_ALL).getResultList();
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return cars.size() == 0 ? null : cars;
	}

	@Override
	public Car findDomainById(Long id) throws DaoException {
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_CAR_ID);
			query.setParameter(CAR_ID, id);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return (Car) query.getSingleResult();
	}

	@Override
	public void delete(Long id) throws DaoException {
		try {
			entityManager.remove(entityManager.find(Car.class, id));
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public Long create(Car domain) throws DaoException {
		try {
            entityManager.persist(domain);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return domain.getModelId();
	}

	@Override
	public void update(Car domain) throws DaoException {
		try {
			Car car = entityManager.find(Car.class, domain.getCarId());
			car.setModelId(domain.getModelId());
			car.setProducerId(domain.getProducerId());
			car.setFuel(domain.getFuel());
			car.setProduceYear(domain.getProduceYear());
			car.setTransmission(domain.getTransmission());
			entityManager.flush();
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Car> getCarsByProducer(Long producer_id) throws DaoException {
		List<Car> cars;
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_PRODUCER_ID);
			query.setParameter(PROD_ID, producer_id);
			cars = query.getResultList();

		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return cars.size() == 0 ? null : cars;
	}

	@Override
	public List<Car> getCarsByModel(Long model_id) throws DaoException {
		List<Car> cars;
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_MODEL_ID);
			query.setParameter(MODEL_ID, model_id);
			cars = query.getResultList();

		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return cars.size() == 0 ? null : cars;
	}

}
