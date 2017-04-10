package com.capalupo.intercom.nc.repository.query;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Igor Capalupo on 09/04/2017.
 */
public class HttpQuery implements IQuery {

    private URL url;

    public HttpQuery(String urlStr){

        try {
            this.url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("URL informed is not a valid one.");
        }

    }

    @Override
    public String toString() {
        return this.url.toString();
    }

}
