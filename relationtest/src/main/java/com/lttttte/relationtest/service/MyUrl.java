package com.lttttte.relationtest.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MyUrl{

    private String url;

    public MyUrl(String url) {
        this.url = url;
    }
}