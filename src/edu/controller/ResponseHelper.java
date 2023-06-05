package edu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public class ResponseHelper {
    public static ResponseEntity<Object> getRedirectResponse(String address){
        URI uri = null;
        try {
            uri = new URI(address);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    public static ResponseEntity<Object> getOkResponse(){
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}
