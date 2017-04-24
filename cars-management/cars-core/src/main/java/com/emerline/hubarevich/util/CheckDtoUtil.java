package com.emerline.hubarevich.util;

import com.emerline.hubarevich.DTOmodels.CarObjectDTO;

public class CheckDtoUtil {
	
	public static boolean checkDto(CarObjectDTO carDto){
		boolean result = true;
		if (carDto.getCarId() == null) {
			result = false;
		} 
		if (carDto.getModelId() == null) {
			result = false;
		}
		if(carDto.getProducerId() == null) {
			result = false;
		}
		return result;
	}

}
