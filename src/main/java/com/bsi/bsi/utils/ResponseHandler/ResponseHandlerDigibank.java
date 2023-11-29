package com.bsi.bsi.utils.ResponseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandlerDigibank {

    public static ResponseEntity<Object> generateResponseDigibank(String message, HttpStatus status, Object res) {

        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", res);

        return new ResponseEntity<>(map, status);

    }
    public static ResponseEntity<Object> generateResponseTransferBsi(String message, HttpStatus status, Object res,Object res2) {

        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", res);
        map.put("Account", res2);

        return new ResponseEntity<>(map, status);

    }

    public static ResponseEntity<Object> getTypeRekening(Object res){
        Map<Object, Object> map = new HashMap<>();
        map.put("data",res);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
