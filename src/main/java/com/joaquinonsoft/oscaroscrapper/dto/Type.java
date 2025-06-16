package com.joaquinonsoft.oscaroscrapper.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Type extends AbstractVehicle {

    public Type(String id, String name) {
        super(id, name);
    }
}
