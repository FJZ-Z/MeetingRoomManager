package com.fjz.gsalar.gsalar.service;


import com.fjz.gsalar.gsalar.exceptions.ResourceNotFoundException;
import com.fjz.gsalar.gsalar.model.Room;
import com.fjz.gsalar.gsalar.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room update(Long id,Room room) throws ResourceNotFoundException {
        existsById(id);
        return save(room);
    }

    public Room findById(Long id) throws ResourceNotFoundException {
        return existsById(id);
    }

    public Room existsById(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room Not Found: "+id));
    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        existsById(id);
        roomRepository.deleteById(id);
    }
}
