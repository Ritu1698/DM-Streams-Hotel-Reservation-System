package com.bl.hotel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class HotelManagementSystem {

    public  String hotelName;
    public  int weekDayRateRegular;
    public  int weekEndRateRegular;
    public  int weekDayRateLoyal;
    public  int weekEndRateLoyal;
    static int  totalCost;
    int rating;
    public static HashMap<String, Integer>hotelNameAndCostMap;
    public static HashMap<String, Integer>hotelNameAndRatingMap;
    public static ArrayList<String> hotelNamesList;

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

    public static String getDayOfWeek(String date) throws ParseException {

        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        Date dt1=format1.parse(date);
        DateFormat format2=new SimpleDateFormat("EE");
        String finalDay=format2.format(dt1);
        return  finalDay;
    }

    public int calculatePrice(ArrayList<String> list, int rewardCustomerOrRegular) throws ParseException {
        Iterator<String > it= list.iterator();
        totalCost = 0;

        if(rewardCustomerOrRegular == 0) {
            while (it.hasNext()) {
                String day = getDayOfWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat"))
                    totalCost += weekEndRateRegular;
                else
                    totalCost += weekDayRateRegular;
            }
        }
        else
        {
            while (it.hasNext()) {

                String day = getDayOfWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat"))
                    totalCost += weekEndRateLoyal;
                else
                    totalCost += weekDayRateLoyal;
            }
        }
        hotelNameAndCostMap.put(hotelName,totalCost);
        hotelNameAndRatingMap.put(hotelName,rating);
        return totalCost;
    }

    public String findCheapestHotel() {

        System.out.println("Hotels in HashMap-\n"+hotelNameAndCostMap+"\n");

        Integer minCost = hotelNameAndCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
        ArrayList<String>cheapHotels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hotelNameAndCostMap.entrySet()) {
            if (minCost >= entry.getValue()) {

                minCost = entry.getValue();
                cheapHotels.add(entry.getKey());
            }
        }
        System.out.println("All the cheapest Hotels List with minimum cost "+minCost+"-\n"+cheapHotels);

        String cheapestMostRatedHotelName = "";
        cheapestMostRatedHotelName = hotelNameAndRatingMap.entrySet()
                .stream()
                .filter(s -> cheapHotels.contains(s.getKey()))
                .max(Map.Entry.comparingByValue()).get().getKey();

        return cheapestMostRatedHotelName;
    }

    public String bestRatedHotel() {
        String maxRate = hotelNameAndRatingMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return maxRate;
    }

    public static void main(String[] args) throws ParseException{

        int rewardCustomerOrRegular;
        System.out.println("Welcome to Hostel Reservation Program in Hotel Management Class");

        HotelManagementSystem h2= new HotelManagementSystem(3,"Lakewood",110,90, 80,80);
        HotelManagementSystem h1= new HotelManagementSystem(4,"Bridgewood",150,50, 110,50);
        HotelManagementSystem h3= new HotelManagementSystem(5,"Ridgewood",220,150, 100,20);

        ArrayList<String> dates=new ArrayList<>();
        dates.add("11/9/2020");
        dates.add("12/9/2020");

        System.out.println("Enter whether a Loyalty Customer or Not\n0 for NO 1 for YES: ");

        Scanner s= new Scanner(System.in);

        rewardCustomerOrRegular=s.nextInt();

        h1.calculatePrice(dates,rewardCustomerOrRegular);
        h2.calculatePrice(dates,rewardCustomerOrRegular);
        h3.calculatePrice(dates,rewardCustomerOrRegular);
        String cheapestHotelGivenDates = h1.findCheapestHotel();
        String bestRatedHotelGivenDates = h1.bestRatedHotel();
        System.out.println("\nCheapest hotel: "+cheapestHotelGivenDates);
        System.out.println("\nBest Rated hotel: "+bestRatedHotelGivenDates);
    }


}