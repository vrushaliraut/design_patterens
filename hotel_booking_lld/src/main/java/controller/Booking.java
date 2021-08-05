package controller;

import constants.PaymentStatus;
import models.Room;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Booking {
    int bookingId;
    int userId;
    int hotelId;
    // we are assuming in a single booking we can book only the rooms of a single hotel
    List<Room> bookedRooms;
    int amount;
    PaymentStatus paymentStatus;
    Date bookingTime;
    Duration duration;
}
