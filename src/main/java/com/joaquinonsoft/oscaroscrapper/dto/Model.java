package com.joaquinonsoft.oscaroscrapper.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
public class Model extends AbstractVehicle{
    @Setter(AccessLevel.NONE)
    private List<Type> types;

    public Model(String id, String name) {
        super(id, name);
        types = new LinkedList<>();
    }

    public void addTypes(List<Type> pType) {
        if (pType != null) {
            types.addAll(pType);
        }
    }

    public void addType(Type type) {
        if (type != null) {
            types.add(type);
        }
    }

    public Type getType(int position) {
        Type type = null;
        if (position >= 0 && position < types.size()) {
            type = types.get(position);
        }
        return type;
    }
}
