package com.emerline.hubarevich.dao.impl;

import com.emerline.hubarevich.dao.CarModelDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.CarModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CarModelDAOImpl implements CarModelDAO {

	private final String PROD_ID = "producerId";
	private final String MODEl_ID = "modelId";
	private final String CAR_ID = "carId";
	private final String QUERY_FIND_ALL = 
			"select M " + 
			"from CarModel M";
	private final String QUERY_FIND_BY_MODEL_ID = 
			"select M " + 
			"from CarModel M  " + 
			"where M.modelId = :modelId";
	private final String QUERY_FIND_BY_PRODUCER_ID = 
			"select M " + 
			"from CarModel M  " + 
			"where M.producerId = :producerId";
	private final String QUERY_FIND_BY_CAR_ID = 
			"SELECT CM " +
            "FROM CarModel CM " +
            "JOIN CM.cars C " +
            "WHERE C.carId= :carId";

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CarModel> findAll() throws DaoException {
		List<CarModel> carModels;
		try {
			carModels = entityManager.createQuery(QUERY_FIND_ALL).getResultList();
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return carModels.size() == 0 ? null : carModels;
	}

	@Override
	public CarModel findDomainById(Long id) throws DaoException {
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_MODEL_ID);
			query.setParameter(MODEl_ID, id);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return (CarModel) query.getSingleResult();
	}

	@Override
	public void delete(Long id) throws DaoException {
		try {
			entityManager.remove(entityManager.find(CarModel.class, id));
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public Long create(CarModel domain) throws DaoException {
		try {
			entityManager.persist(domain);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return domain.getModelId();
	}

	@Override
	public void update(CarModel domain) throws DaoException {
		try {
            CarModel carModel = entityManager.find(CarModel.class, domain.getModelId());
            carModel.setModelName(domain.getModelName());
            entityManager.flush();
        } catch (PersistenceException e) {
            throw new DaoException(e);
        }

	}

	@Override
	public List<CarModel> getModelsByProducer(Long producerId) throws DaoException {
		List<CarModel> carModels;
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_PRODUCER_ID);
			query.setParameter(PROD_ID, producerId);
			carModels = query.getResultList();
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return carModels.size() == 0 ? null : carModels;
	}

	@Override
	public CarModel getModelByCar(Long carId) throws DaoException {
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_CAR_ID);
			query.setParameter(CAR_ID, carId);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return (CarModel) query.getSingleResult();
	}

}