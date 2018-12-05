package com.example.ruxing.serializationpractice.entity;

/**
 * Created by ruxing on 2018/12/5.
 */

public class SerializableSubclassEntity extends SerializableParentEntity {

    private int subclassAge;
    private String subclassName;

    public int getSubclassAge() {
        return subclassAge;
    }

    public void setSubclassAge(int subclassAge) {
        this.subclassAge = subclassAge;
    }

    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }
}
