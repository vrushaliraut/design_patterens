package models;

import constants.Facility;

import java.util.List;

public class Hotel {
    int hotelId;
    String hotelName;
    Address address;

    // hotel contains list of rooms
    List<Room> rooms;
    float rating;
    Facility facility;
}
