package com.emerline.hubarevich.util;

import com.emerline.hubarevich.domain.Transmission;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class TransmissionToEnumConverter implements AttributeConverter<Transmission, String>{

	@Override
	public String convertToDatabaseColumn(Transmission value) {
		return value.toString();
	}

	@Override
	public Transmission convertToEntityAttribute(String value) {
		return Transmission.valueOf(value);
	}

}
