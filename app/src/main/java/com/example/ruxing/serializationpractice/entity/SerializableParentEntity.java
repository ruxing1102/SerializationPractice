package com.example.ruxing.serializationpractice.entity;

import java.io.Serializable;

/**
 * Created by ruxing on 2018/12/5.
 */

public class SerializableParentEntity implements Serializable{

    public int parentAge;
    public String parentName;

    public int getParentAge() {
        return parentAge;
    }

    public void setParentAge(int parentAge) {
        this.parentAge = parentAge;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
