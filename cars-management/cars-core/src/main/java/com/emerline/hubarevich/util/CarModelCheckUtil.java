package com.emerline.hubarevich.util;

import com.emerline.hubarevich.domain.CarModel;

public class CarModelCheckUtil {

	public static boolean checkCarModel(CarModel carModel) {
		boolean result = true;

		if (carModel.getModelName() == null || carModel.getModelName().length() > 255) {
			result = false;
		}

		if (carModel.getProducerId() == null || carModel.getProducerId() < 0) {
			result = false;
		}
		return result;
	}

}
