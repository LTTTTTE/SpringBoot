package com.lttttte.thymeleaftest04.domain;

public enum WeatherType {
    sunny("맑음"),
    cloudy("흐림"),
    rainy("우천");

    private String weather;

    WeatherType(String weather) {
        this.weather = weather;
    }

    public String getValue(){
        return this.weather;
    }
}
