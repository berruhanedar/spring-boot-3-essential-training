package com.berru.room_web_app.service;

import com.berru.room_web_app.data.entity.Position;
import com.berru.room_web_app.data.entity.StaffMember;
import com.berru.room_web_app.data.repository.StaffRepository;
import com.berru.room_web_app.web.model.Staff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll()
                .stream()
                .map(this::getStaffFromEntity)
                .collect(Collectors.toList());
    }

    public Staff getStaffById(UUID id) {
        return staffRepository.findById(id)
                .map(this::getStaffFromEntity)
                .orElse(null);
    }

    public Staff addStaff(Staff staff) {
        StaffMember entity = new StaffMember();

        entity.setFirstName(staff.getFirstName());
        entity.setLastName(staff.getLastName());
        entity.setPosition(
                Position.valueOf(staff.getPosition())
        );

        StaffMember savedEntity = staffRepository.save(entity);

        return getStaffFromEntity(savedEntity);
    }

    public Staff updateStaff(Staff staff) {
        StaffMember entity = staffRepository.findById(staff.getEmployeeId())
                .orElseThrow(() ->
                        new RuntimeException("Staff member not found"));

        entity.setFirstName(staff.getFirstName());
        entity.setLastName(staff.getLastName());
        entity.setPosition(
                Position.valueOf(staff.getPosition())
        );

        StaffMember updatedEntity = staffRepository.save(entity);

        return getStaffFromEntity(updatedEntity);
    }

    public void deleteStaff(UUID id) {
        staffRepository.deleteById(id);
    }

    private Staff getStaffFromEntity(StaffMember entity) {
        return new Staff(
                entity.getEmployeeId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPosition().toString()
        );
    }
}