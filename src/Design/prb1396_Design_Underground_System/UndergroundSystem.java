package Design.prb1396_Design_Underground_System;

import java.util.HashMap;
import java.util.Map;

/**
  * UndergroundSystem.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class UndergroundSystem {
    public static class CheckInDetails {
        String stationName;
        int checkinTime;

        public CheckInDetails(String station, int checkinTime){
            this.stationName = station;
            this.checkinTime = checkinTime;
        }
    }

    public static class JourneyData {
        int totaltime;
        int trips;

        public JourneyData(){
            this.totaltime = 0;
            this.trips = 0;
        }
    }

    // Map to store customer checkin and travel times
    Map<Integer, CheckInDetails> checkinInfo;
    Map<String, JourneyData > journeyInfo;

    public UndergroundSystem() {
        this.checkinInfo = new HashMap<>();
        this.journeyInfo = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        // Add checkin info to hashmap
        checkinInfo.put( id, new CheckInDetails( stationName, t ) );
    }

    public void checkOut(int id, String stationName, int t) {
        // Get the checkinInfo for start times
        CheckInDetails checkin = this.checkinInfo.get( id );

        if(checkin!=null){
            String startStation = checkin.stationName;
            int startTime = checkin.checkinTime;

            String journey = startStation +"->" + stationName;
            JourneyData journeyMap = journeyInfo.getOrDefault( journey, new JourneyData() );

            // Update total time for journey and trips
            journeyMap.totaltime += (t-startTime);
            journeyMap.trips ++;
            journeyInfo.put( journey, journeyMap );

            // Remove from checkin
            checkinInfo.remove( id );
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        String journeyKey = startStation +"->"+endStation;
        // get journey details
        JourneyData journey = journeyInfo.get( journeyKey );

        // return average if not null
        if(journey != null) {
            return (double)journey.totaltime/journey.trips;
        }

        return 0.0;
    }

    public static void main( String[] args ) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000.
    }
}
