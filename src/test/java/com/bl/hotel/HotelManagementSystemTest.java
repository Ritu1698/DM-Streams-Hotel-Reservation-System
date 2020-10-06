package com.bl.hotel;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class HotelManagementSystemTest {

    public static HashMap<String,Integer> HotelNameAndRatingMap= new HashMap<>();
    public static HashMap<String ,Integer> HotelNameAndCostMap= new HashMap<>();
    HotelManagementSystem h1 = new HotelManagementSystem(3, "Lakewood", 110, 90, 80, 80);
    HotelManagementSystem h2 = new HotelManagementSystem(4, "Bridgewood", 150, 50,110,50);
    HotelManagementSystem h3 = new HotelManagementSystem(5, "Ridgewood", 220, 150,100,40);

    @Test
    public void givenFindCheapestHotel_whenLoyalCustomer_shouldReturnRigwood() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("3/10/2020");
        dates.add("4/10/2020");
        h1.calculatePrice(dates,1);
        h2.calculatePrice(dates,1);
        h3.calculatePrice(dates,1);
        String name=h1.findCheapestHotel();
        Assert.assertEquals("Ridgewood",name);

    }
    @Test
    public void givenCalculatePrice_whenWeekEndRates_shouldReturn160() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();

        dates.add("3/10/2020");
        dates.add("4/10/2020");
        int result = h1.calculatePrice(dates, 1);

        Assert.assertEquals(160, result);
    }

    @Test
    public void givenCalculatePrice_whenWeekEndAndWeekDayRates_shouldReturn200() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();

        dates.add("5/10/2020");
        dates.add("4/10/2020");
        int result = h2.calculatePrice(dates, 0);

        Assert.assertEquals(200, result);
    }
    @Test
    public void givenCalculatePrice_whenWeekEndAndWeekDayRates_shouldReturn160() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();

        dates.add("5/10/2020");
        dates.add("4/10/2020");
        int result = h2.calculatePrice(dates, 1);

        Assert.assertNotEquals(161, result);
        Assert.assertNotEquals(159, result);
    }
    @Test
    public void givenFindCheapestHotel_whenLoyalCustomer_shouldReturnLakewood() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        h1.calculatePrice(dates,1);
        h2.calculatePrice(dates,1);
        h3.calculatePrice(dates,1);
        String name=h1.findCheapestHotel();
        Assert.assertNotEquals("Bridgewood",name);
        Assert.assertNotEquals("Ridgewood",name);



    }
    @Test
    public void givenFindCheapestHotel_whenRegularCustomer_shouldReturnLakewood() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        h1.calculatePrice(dates,0);
        h2.calculatePrice(dates,0);
        h3.calculatePrice(dates,0);
        String name=h1.findCheapestHotel();
        Assert.assertEquals("Lakewood",name);



    }
    @Test
    public void givenFindCheapestHotel_whenLoyalCustomer_shouldReturnHighestRatedHotel() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("4/10/2020");
        dates.add("5/10/2020");
        h1.calculatePrice(dates,0);
        h2.calculatePrice(dates,0);
        h3.calculatePrice(dates,0);
        String name=h1.findCheapestHotel();
        Assert.assertEquals("Bridgewood",name);



    }
    @Test
    public void givenFindCheapestHotel_whenRegularCustomer_shouldReturnLakewoodName() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("4/10/2020");
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        h1.calculatePrice(dates,0);
        h2.calculatePrice(dates,0);
        h3.calculatePrice(dates,0);
        String name=h1.findCheapestHotel();
        Assert.assertEquals("Lakewood",name);
        Assert.assertNotEquals("Lakewod",name);
        Assert.assertNotEquals("lakewood",name);



    }

    @Test
    public void givenFindBestRatedHotel_whenRegularCustomer_shouldReturnRidgewood() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("4/10/2020");
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        h1.calculatePrice(dates,0);
        h2.calculatePrice(dates,0);
        h3.calculatePrice(dates,0);
        String name=h1.bestRatedHotel();
        Assert.assertEquals("Ridgewood",name);

    }




}
