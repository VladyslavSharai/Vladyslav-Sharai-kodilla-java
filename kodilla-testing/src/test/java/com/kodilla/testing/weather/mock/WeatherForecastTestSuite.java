package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;
    private Map<String, Double> temperaturesMap;
    private WeatherForecast weatherForecast;

    @BeforeEach
    void setUp() {
        temperaturesMap = new HashMap<>();
        weatherForecast = new WeatherForecast(temperaturesMock);

        temperaturesMap.put("Rzeszow", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Wroclaw", 24.0);
        temperaturesMap.put("Warszawa", 25.0);
    }

    @Test
    void testCalculateForecastWithMock() {
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assertions.assertEquals(4, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperatures(){
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        double result = weatherForecast.calculateAverageTemperatures();

        Assertions.assertEquals(25.0, result);
    }

    @Test
    void testCalculatePairedMedianeTemperatures(){
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        double result = weatherForecast.calculateMedianeTemperatures();

        Assertions.assertEquals(25.0, result);
    }

    @Test
    void testCalculateUnairedMedianeTemperatures(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Warszawa", 24.0);
        temperaturesMap.put("Szczecin", 25.0);
        temperaturesMap.put("Poznań", 27.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        double result = weatherForecast.calculateMedianeTemperatures();

        Assertions.assertEquals(25.0, result);
    }

    @Test
    void testCalculateAverageAndMedianWhenMapIsEmpty(){
        Map<String, Double> emptyTemperaturesMap = new HashMap<>();
        when(temperaturesMock.getTemperatures()).thenReturn(emptyTemperaturesMap);

        double resultMediane = weatherForecast.calculateMedianeTemperatures();
        double resultAverage = weatherForecast.calculateAverageTemperatures();

        Assertions.assertEquals(0.0, resultMediane);
        Assertions.assertEquals(0.0, resultAverage);
    }
}
