package com.example.springCRUD.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

import java.io.Serializable;


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
