package com.example.app.dto;

import lombok.Data;

import java.util.Map;

@Data
public class EventRequest {

    private String type;

    private String user;

    private Map<String, Object> metadata;
}
