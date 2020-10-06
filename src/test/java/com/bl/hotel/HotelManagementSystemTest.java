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



}
