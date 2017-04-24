package com.emerline.hubarevich.business.impl;

import com.emerline.hubarevich.business.ProducerService;
import com.emerline.hubarevich.business.exception.LogicException;
import com.emerline.hubarevich.dao.ProducerDAO;
import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Producer;
import com.emerline.hubarevich.util.ProducerCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {
	
	@Autowired
	private ProducerDAO producerDao;

	@Override
	public Long createProducer(Producer producer) throws LogicException {
		Long backId = 0L;
		try {
			if (ProducerCheckUtil.checkProducer(producer)) {
				backId = producerDao.create(producer);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return backId;
	}

	@Override
	public void deleteProducer(Long producerId) throws LogicException {
		try {
			if (producerId != null) {
				producerDao.delete(producerId);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}

	}

	@Override
	public void updateProducer(Producer producer) throws LogicException {
		try {
			if (ProducerCheckUtil.checkProducer(producer)) {
				producerDao.update(producer);
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}

	}

	@Override
	public List<Producer> getListOfProducers() throws LogicException {
		List<Producer> producers = new ArrayList<>();
		try {
			producers.addAll(producerDao.findAll());
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return producers;
	}

	@Override
	public Producer getProducerById(Long producerId) throws LogicException {
		Producer producer = null;
		try {
			if (producerId != null && producerId > 0L) {
				producer = producerDao.findDomainById(producerId);
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return producer;
	}

	@Override
	public Producer getProducerByCar(Long carId) throws LogicException {
		Producer producer = null;
		try {
			if(carId != null && carId > 0L) {
				producer = producerDao.getProducerByCarId(carId);
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return producer;
	}

	@Override
	public Producer getProducerByModel(Long modelId) throws LogicException {
		Producer producer = null;
		try {
			if(modelId != null && modelId > 0L) {
				producer = producerDao.getProducerByModelId(modelId);
			}
		} catch (DaoException e) {
			throw new LogicException();
		}
		return producer;
	}

}
