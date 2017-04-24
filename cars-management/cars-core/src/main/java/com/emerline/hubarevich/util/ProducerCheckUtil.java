package com.emerline.hubarevich.util;

import com.emerline.hubarevich.domain.Producer;

public class ProducerCheckUtil {
	
	public static boolean checkProducer(Producer producer) {
		if (producer.getProducerName() != null & producer.getProducerName().length() < 255){
			return true;
		}
		return false;
	}

}
