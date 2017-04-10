package com.capalupo.intercom.nc.model;

import com.capalupo.intercom.nc.service.util.GeoHelper;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class Customer {

    private Long user_id;

    private String name;

    private Double latitude;

    private Double longitude;

    public Customer(Long id, String name, Double latitude, Double longitude){

        if (null == latitude || null == longitude) throw new IllegalArgumentException("Customer has no latitude and/or longitude data.");

        this.user_id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Long getId() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getDistanceFromBase() {
        return GeoHelper.calculateDistanceFromBase(this.latitude, this.longitude);
    }

    public boolean isNearBase(){
        return getDistanceFromBase() <= 100D;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!user_id.equals(customer.user_id)) return false;
        return getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        int result = user_id.hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("************Customer***********\n");
        sb.append("NAME : [").append(getName().toUpperCase()).append("]\n");
        sb.append("ID : [").append(getId()).append("]\n");
        sb.append("DISTANCE FROM INTERCOM OFFICE : [").append(getDistanceFromBase()).append(" KM]\n");
        sb.append("*******************************\n\n");
        return sb.toString();
    }
}
