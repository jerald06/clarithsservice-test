package com.clarit.hs.service.items;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Created by mnachiappan on 1/4/23.
 */
@Document("rooms")
@JsonInclude(value = Include.NON_NULL)
public class Room extends RepresentationModel<Room>  {
    private int number;
    private RoomType roomType;
    private boolean isOccupied;
    private Date availbility;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Date getAvailbility() {
        return availbility;
    }

    public void setAvailbility(Date availbility) {
        this.availbility = availbility;
    }

    @AccessType(AccessType.Type.PROPERTY)
    public void setLinks(List<Link> links) {
        super.removeLinks();
        super.add(links);
    }
}
