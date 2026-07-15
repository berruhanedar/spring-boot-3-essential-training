package com.berru.room_web_app.web.api;

import com.berru.room_web_app.service.RoomService;
import com.berru.room_web_app.web.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {

    private final RoomService roomService;

    public RoomApiController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAll(){
        return roomService.getAllRooms();
    }

    @GetMapping("/id")
    public Room getRoom(@PathVariable(name="id") UUID id){
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @PutMapping
    public Room updateRoom(@RequestBody Room room){
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable UUID id ){
        roomService.deleteRoom(id);
    }
}
