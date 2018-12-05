package com.example.ruxing.serializationpractice.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ruxing on 2018/11/29.
 */

public class OuterEntity implements Parcelable{

    private int age;
    private String name;

    public OuterEntity(){

    }

    protected OuterEntity(Parcel in) {
        age = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OuterEntity> CREATOR = new Creator<OuterEntity>() {
        @Override
        public OuterEntity createFromParcel(Parcel in) {
            return new OuterEntity(in);
        }

        @Override
        public OuterEntity[] newArray(int size) {
            return new OuterEntity[size];
        }
    };

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
