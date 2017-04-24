package com.emerline.hubarevich.client.entity;

import com.emerline.hubarevich.domain.Producer;

/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
public class ProducerProxy {

    private Long producerProxyId;
    private String producerProxyName;

    public ProducerProxy(Producer producer) {
        this.producerProxyId = producer.getProducerId();
        this.producerProxyName = producer.getProducerName();
    }

    public Long getProducerProxyId() {
        return producerProxyId;
    }

    public void setProducerProxyId(Long producerProxyId) {
        this.producerProxyId = producerProxyId;
    }

    public String getProducerProxyName() {
        return producerProxyName;
    }

    public void setProducerProxyName(String producerProxyName) {
        this.producerProxyName = producerProxyName;
    }
}
