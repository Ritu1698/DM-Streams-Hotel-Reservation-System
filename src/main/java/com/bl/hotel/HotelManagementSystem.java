package com.bl.hotel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class HotelManagementSystem {

    public String hotelName;
    public int weekDayRateRegular;
    public int weekEndRateRegular;
    public int weekDayRateLoyal;
    public int weekEndRateLoyal;
    static int totalCost;
    int rating;
    public static HashMap<String, Integer> hotelNameAndCostMap;
    public static HashMap<String, Integer> hotelNameAndRatingMap;
    public static ArrayList<String> hotelNamesList;

    //Parameterized Constructor
    public HotelManagementSystem(int rating, String hotelName, int weekDayRateRegular, int weekEndRateRegular, int weekDayRateLoyal, int weekEndRateLoyal) {
        this.rating = rating;
        this.hotelName = hotelName;
        this.weekDayRateRegular = weekDayRateRegular;
        this.weekEndRateRegular = weekEndRateRegular;
        this.weekDayRateLoyal = weekDayRateLoyal;
        this.weekEndRateLoyal = weekEndRateLoyal;
        hotelNameAndCostMap = new HashMap<>();
        hotelNameAndRatingMap = new HashMap<>();
        hotelNamesList = new ArrayList<>();

    }

    //Function to Give Day Of Week
    public static String getDayOfWeek(String date) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(date);
        DateFormat format2 = new SimpleDateFormat("EE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    //Function to Calculate Total Cost Of A Hotel Given Dates List
    public int calculatePrice(ArrayList<String> list, int rewardCustomerOrRegular) throws ParseException {
        Iterator<String> it = list.iterator();
        totalCost = 0;

        if (rewardCustomerOrRegular == 0) {
            while (it.hasNext()) {
                String day = getDayOfWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat"))
                    totalCost += weekEndRateRegular;
                else
                    totalCost += weekDayRateRegular;
            }
        } else {
            while (it.hasNext()) {

                String day = getDayOfWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat"))
                    totalCost += weekEndRateLoyal;
                else
                    totalCost += weekDayRateLoyal;
            }
        }
        hotelNameAndCostMap.put(hotelName, totalCost);
        hotelNameAndRatingMap.put(hotelName, rating);
        return totalCost;
    }

    //Function to Find The Cheapest Hotel
    public String findCheapestHotel() {

        System.out.println("Hotels in HashMap-\n" + hotelNameAndCostMap + "\n");

        Integer minCost = hotelNameAndCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
        ArrayList<String> cheapHotels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hotelNameAndCostMap.entrySet()) {
            if (minCost >= entry.getValue()) {

                minCost = entry.getValue();
                cheapHotels.add(entry.getKey());
            }
        }
        System.out.println("All the cheapest Hotels List with minimum cost " + minCost + "-\n" + cheapHotels);

        List<Map.Entry<String, Integer>> cheapHotelsUsingStream = new ArrayList<>();
        cheapHotelsUsingStream = hotelNameAndCostMap.entrySet().stream().filter(s -> s.getValue() <= hotelNameAndCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue()).collect(Collectors.toList());

        String cheapestMostRatedHotelName = "";
        cheapestMostRatedHotelName = hotelNameAndRatingMap.entrySet()
                .stream()
                .filter(s -> cheapHotels.contains(s.getKey()))
                .max(Map.Entry.comparingByValue()).get().getKey();

        return cheapestMostRatedHotelName;
    }

    //Function to Best Rated Hotel
    public String bestRatedHotel() {
        String maxRate = hotelNameAndRatingMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return maxRate;
    }

    //Main Function
    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome to Hostel Reservation Program in Hotel Management Class");
    }
}