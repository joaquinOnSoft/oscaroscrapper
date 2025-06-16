package com.joaquinonsoft.oscaroscrapper.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Type extends AbstractVehicle {

    public Type(String id, String name) {
        super(id, name);
    }
}
