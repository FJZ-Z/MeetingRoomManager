package com.fjz.gsalar.gsalar.controller;
import com.fjz.gsalar.gsalar.exceptions.ResourceNotFoundException;
import com.fjz.gsalar.gsalar.model.Room;
import com.fjz.gsalar.gsalar.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/room")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Room> getAllRooms(){
        return  roomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
        Room room = roomService.findById(id);
        return ResponseEntity.ok().body(room);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@Valid @RequestBody Room room){
        return roomService.save(room);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id,@Valid @RequestBody Room roomD) throws ResourceNotFoundException {
        Room room = roomService.update(id,roomD);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        roomService.deleteById(id);
    }
}
