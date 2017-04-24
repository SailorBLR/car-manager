package com.emerline.hubarevich.client.entity;

import com.emerline.hubarevich.domain.CarModel;

/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
public class CarModelProxy {

    private Long carModelProxyId;
    private Long carModelProxyProducerId;
    private String carModelProxyName;

    public CarModelProxy(CarModel carModel) {
        this.carModelProxyId = carModel.getModelId();
        this.carModelProxyProducerId = carModel.getProducerId();
        this.carModelProxyName = carModel.getModelName();
    }

    public Long getCarModelProxyId() {
        return carModelProxyId;
    }

    public void setCarModelProxyId(Long carModelProxyId) {
        this.carModelProxyId = carModelProxyId;
    }

    public Long getCarModelProxyProducerId() {
        return carModelProxyProducerId;
    }

    public void setCarModelProxyProducerId(Long carModelProxyProducerId) {
        this.carModelProxyProducerId = carModelProxyProducerId;
    }

    public String getCarModelProxyName() {
        return carModelProxyName;
    }

    public void setCarModelProxyName(String carModelProxyName) {
        this.carModelProxyName = carModelProxyName;
    }

    @Override
    public String toString() {
        return "CarModelProxy{" +
                "carModelProxyId=" + carModelProxyId +
                ", carModelProxyProducerId=" + carModelProxyProducerId +
                ", carModelProxyName='" + carModelProxyName + '\'' +
                '}';
    }
}
