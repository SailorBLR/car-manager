package com.emerline.hubarevich.util;

import com.emerline.hubarevich.domain.Fuel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class FuelToEnumConverter implements AttributeConverter<Fuel, String>{

	@Override
	public String convertToDatabaseColumn(Fuel value) {
		return value.toString();
	}

	@Override
	public Fuel convertToEntityAttribute(String value) {
		return Fuel.valueOf(value);
	}

}
