package com.berru.room_web_app.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String position;
}