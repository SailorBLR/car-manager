package com.emerline.hubarevich.business;

import com.emerline.hubarevich.DTOmodels.CarObjectDTO;
import com.emerline.hubarevich.business.exception.LogicException;
import sun.rmi.runtime.Log;

import java.util.List;

public interface DTOService {

	/**
	 * Creates CarObjectDTO object
	 * 
	 * @param Long
	 *            Car identifier
	 * @return CarObjectDTO Object
	 * @throws LogicException
	 *             if DaoException obtained
	 */
	CarObjectDTO getCarDTO(Long carId) throws LogicException;

	List<CarObjectDTO> getListOfDtos() throws LogicException;

}
