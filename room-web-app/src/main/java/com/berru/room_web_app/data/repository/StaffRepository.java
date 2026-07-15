package com.berru.room_web_app.data.repository;

import com.berru.room_web_app.data.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffMember, UUID> {
}