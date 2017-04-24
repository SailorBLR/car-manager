package com.emerline.hubarevich.dao.impl;

import com.emerline.hubarevich.dao.ProducerDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Producer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProducerDAOImpl implements ProducerDAO {

	private final String PROD_ID = "producerId";
	private final String MODEL_ID = "modelId";
	private final String CAR_ID = "carId";
	
	private final String QUERY_FIND_ALL = 
			"select P " + 
	        "from Producer P";
	private final String QUERY_FIND_BY_ID = 
            "select P " +
            "from Producer P  " +
            "where P.producerId = :producerId";
	private final String QUERY_FIND_BY_CAR_ID = 
			"SELECT P " +
            "FROM Producer P " +
            "JOIN P.cars C " +
            "WHERE C.carId= :carId";
	private final String QUERY_FIND_BY_MODEL_ID = 
			"SELECT P " +
            "FROM Producer P " +
            "JOIN P.carModels CM " +
            "WHERE CM.modelId= :modelId";

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Producer> findAll() throws DaoException {
		List<Producer> producers;
		try {
			producers = entityManager.createQuery(QUERY_FIND_ALL, Producer.class).getResultList();
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return producers.size() == 0 ? null : producers;
	}

	@Override
	public Producer findDomainById(Long id) throws DaoException {
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_ID);
			query.setParameter(PROD_ID, id);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return (Producer) query.getSingleResult();
	}

	@Override
	public void delete(Long id) throws DaoException {
		try {
            entityManager.remove(entityManager.find(Producer.class, id));
        } catch (PersistenceException e) {
            throw new DaoException(e);
        }
	}

	@Override
	public Long create(Producer domain) throws DaoException {
		try {
			entityManager.persist(domain);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return domain.getProducerId();
	}

	@Override
	public void update(Producer domain) throws DaoException {
		try {
            Producer producer = entityManager.find(Producer.class, domain.getProducerId());
            producer.setProducerName(producer.getProducerName());
            entityManager.flush();
        } catch (PersistenceException e) {
            throw new DaoException(e);
        }
	}

	@Override
	public Producer getProducerByCarId(Long carId) throws DaoException {
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_CAR_ID);
			query.setParameter(CAR_ID, carId);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return (Producer) query.getSingleResult();
	}

	@Override
	public Producer getProducerByModelId(Long modelId) throws DaoException {
		Query query;
		try {
			query = entityManager.createQuery(QUERY_FIND_BY_MODEL_ID);
			query.setParameter(MODEL_ID, modelId);
		} catch (PersistenceException e) {
			throw new DaoException(e);
		}
		return (Producer) query.getSingleResult();
	}

}
