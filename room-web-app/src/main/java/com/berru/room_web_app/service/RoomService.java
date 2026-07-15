package com.berru.room_web_app.service;

import com.berru.room_web_app.data.entity.RoomEntity;
import com.berru.room_web_app.data.repository.RoomRepository;
import com.berru.room_web_app.web.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(getRoomFromEntity(e)));
        return rooms;
    }

    public Room getRoomById(UUID id) {
        Optional<RoomEntity> entity = roomRepository.findById(id);
        if (entity.isPresent()) {
            return null;
        } else {
            return getRoomFromEntity(entity.get());
        }
    }

    public Room addRoom(Room room) {
        RoomEntity entity = getRoomEntityFromRoom(room);
        entity = roomRepository.save(entity);
        return getRoomFromEntity(entity);
    }

    public Room updateRoom(Room room) {
        RoomEntity entity = getRoomEntityFromRoom(room);
        entity = roomRepository.save(entity);
        return getRoomFromEntity(entity);
    }

    public void deleteRoom(UUID id) {
        roomRepository.deleteById(id);
    }

    private Room getRoomFromEntity(RoomEntity roomEntity) {
        return new Room(roomEntity.getRoomId(), roomEntity.getName(), roomEntity.getNumber(), roomEntity.getBedInfo());
    }

    private RoomEntity getRoomEntityFromRoom(Room room) {
        return new RoomEntity(room.getId(), room.getName(), room.getNumber(), room.getInfo());
    }

}
