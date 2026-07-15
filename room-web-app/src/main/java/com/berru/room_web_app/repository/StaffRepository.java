package com.berru.room_web_app.repository;

import com.berru.room_web_app.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffMember, String> {
}
