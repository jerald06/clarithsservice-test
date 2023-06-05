package com.clarit.hs.service.items;

import java.util.List;

/**
 * Created by mnachiappan on 1/4/23.
 */

public interface IProperty {

    public List<Room> getAll(boolean occupied) ;
    public Room book(Room room) ;
    public List<Room> get(int roomNumber) ;
    public void cancelBooking(int number) ;


}
