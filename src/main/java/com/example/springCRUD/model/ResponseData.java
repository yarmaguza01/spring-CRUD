package com.example.springCRUD.model;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ResponseData {
    private String status;
    private String message;
    private Object data;

    public ResponseData() {
    }
    public ResponseData(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
