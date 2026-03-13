package com.harish.wind_monitoring.model;

public class WindData {
    public String startTime;
    public double actualGen;
    public double forecastGen;

    public WindData(String startTime, double actualGen, double forecastGen) {
        this.startTime = startTime;
        this.actualGen = actualGen;
        this.forecastGen = forecastGen;
    }
}