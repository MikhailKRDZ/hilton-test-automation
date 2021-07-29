package com.epam.hilton.framework.service;

public class Rooms {

    private final int roomsNumber;
    private final int guestsNumber;

    public Rooms(int roomsNumber, int guestsNumber) {
        this.roomsNumber = roomsNumber;
        this.guestsNumber = guestsNumber;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public int getGuestsNumber() {
        return guestsNumber;
    }

}
