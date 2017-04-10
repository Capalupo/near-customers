package com.capalupo.intercom.nc.service.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class GeoHelper {
    /**
     * Earth’s radius (using kilometers)
     */
    public static final double R = 6371;
    public static final String BASE_LATITUDE = "53.3393";
    public static final String BASE_LONGITUDE = "-6.2576841";


    public static double calculateHaversineDist(double latA, double longA, double latB, double longB) {

        double dLat = Math.toRadians(latB - latA);
        double dLon = Math.toRadians(longB - longA);

        latA = Math.toRadians(latA);
        latB = Math.toRadians(latB);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(latA) * Math.cos(latB);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = R * c;

        NumberFormat numberFormat = new DecimalFormat("##.##");
        return Double.parseDouble(numberFormat.format(dist));
    }

    public static double calculateDistanceFromBase(double candidateLatitude, double candidateLongitude){

        return GeoHelper.calculateHaversineDist(Double.parseDouble(BASE_LATITUDE), Double.parseDouble(BASE_LONGITUDE)
                                                ,candidateLatitude,candidateLongitude);

    }

}
