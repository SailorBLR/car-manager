package com.emerline.hubarevich.util;

import com.emerline.hubarevich.domain.Car;

import java.time.LocalDate;

public class CarCheckUtil {
	private static final int YEAR = 1900;
	private static final int MONTH = 1;
	private static final int DAY = 1;
	
	private static LocalDate startYear = LocalDate.of(YEAR,MONTH,DAY);
	
	public static boolean checkCar(Car car){
		boolean result = true;
		if (car.getFuel() == null) {
			result = false;
		}
		if (car.getTransmission() == null) {
			result = false;
		}
		if (car.getProduceYear().isAfter(LocalDate.now()) ||
				car.getProduceYear().isBefore(startYear)){
			result = false;
		}
		return result;
	}

}
