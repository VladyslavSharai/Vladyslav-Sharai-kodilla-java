package com.kodilla.stream.world;

import com.kodilla.stream.sand.Europe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland", new BigDecimal("38000000")));
        europe.addCountry(new Country("Germany", new BigDecimal("83000000")));
        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("Japan", new BigDecimal("125000000")));
        asia.addCountry(new Country("China", new BigDecimal("1400000000")));
        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(new Country("USA", new BigDecimal("330000000")));

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);

        BigDecimal totalPeople = world.getPeopleQuantity();
        BigDecimal expectedPeople = new BigDecimal("1976000000");

        Assertions.assertEquals(expectedPeople, totalPeople);

    }
}
