package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            resultMap.put(entry.getKey(), entry.getValue() + 1);
        }
        return resultMap;
    }

    public double calculateAverageTemperatures() {

        if(temperatures.getTemperatures().isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            sum += entry.getValue();
        }
        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedianeTemperatures(){
        if(temperatures.getTemperatures().isEmpty()) {
            return 0;
        }

        List<Double> temperatureList = new ArrayList<>(temperatures.getTemperatures().values());

        Collections.sort(temperatureList);

        int size = temperatureList.size();

        if(size % 2 != 0){
            return temperatureList.get(size / 2);
        }
        else{
            return (temperatureList.get(size / 2 - 1) + temperatureList.get(size / 2)) / 2.0;
        }

    }
}

