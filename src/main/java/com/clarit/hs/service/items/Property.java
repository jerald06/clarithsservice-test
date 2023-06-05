package com.clarit.hs.service.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;
import com.clarit.hs.service.items.repo.ItemRepository;
import java.util.List;

/**
 * Created by mnachiappan on 1/4/23.
 */
@Service
public class Property implements IProperty {
    @Autowired
    ItemRepository itemRepository;
    @Override
    public List<Room> getAll(boolean occupied) {
        return getAllRooms();
    }

    @Override
    public Room book(Room room) {
        return bookRoom(room);
    }

    @Override
    public List<Room> get(int roomNumber) {
        return itemRepository.findByNumber(roomNumber);
    }

    @Override
    public void cancelBooking(int number) {

        itemRepository.delete(itemRepository.deleteByNumber(number));
    }

    private List<Room> getAllRooms(){
        return itemRepository.findAll();
    }

    private Room bookRoom(Room room) {

        return itemRepository.save(room);
    }
}
