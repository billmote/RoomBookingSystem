package com.booker.domain;

import com.booker.database.RoomMapper;
import com.booker.database.impl.RoomMapperImpl;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private int id;
    private String name;
    private Hotel hotel;
    private String description;
    private Float price;

    public Catalogue() {

    }

    public List<Room> getRooms() {
        RoomMapper mapper = new RoomMapperImpl();
        List<Room> rooms = mapper.findRoomsByCatalogueId(this.id);
        return rooms;
    }

    public String getRoomNumberStr() {
        List<Room> rooms = getRooms();
        String[] roomNumberList = new String[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            roomNumberList[i] = rooms.get(i).getNumber();
        }
        return String.join(",", roomNumberList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
