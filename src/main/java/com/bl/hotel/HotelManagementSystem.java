package com.bl.hotel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;


public class HotelManagementSystem {

    public  String hotelName;
    public  int weekDayRateRegular;
    public  int weekEndRateRegular;
    public  int weekDayRateLoyal;
    public  int weekEndRateLoyal;
    static int  totalCost;
    int rating;
    public HashMap<String, Integer>hotelNameAndCostMap;
    public HashMap<String, Integer>hotelNameAndRatingMap;
    public ArrayList<String> hotelNamesList;

    public HotelManagementSystem(int rating,String hotelName,int weekDayRateRegular, int weekEndRateRegular, int weekDayRateLoyal, int weekEndRateLoyal) {
        this.rating=rating;
        this.hotelName = hotelName;
        this.weekDayRateRegular = weekDayRateRegular;
        this.weekEndRateRegular = weekEndRateRegular;
        this.weekDayRateLoyal = weekDayRateLoyal;
        this.weekEndRateLoyal = weekEndRateLoyal;
        hotelNameAndCostMap = new HashMap<>();
        hotelNameAndRatingMap = new HashMap<>();
        hotelNamesList = new ArrayList<>();

    }

    public static void main(String[] args){
        System.out.println("Welcome to Hostel Reservation Program in Hotel Management Class");

        HotelManagementSystem h2= new HotelManagementSystem(3,"Lakewood",110,90, 80,80);
        HotelManagementSystem h1= new HotelManagementSystem(4,"Bridgewood",150,50, 110,50);
        HotelManagementSystem h3= new HotelManagementSystem(5,"Ridgewood",220,150, 100,20);
    }


}