package com.example.ruxing.serializationpractice.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ruxing on 2018/12/5.
 */

public class ParcelableSubclassEntity extends ParcelableParentEntity implements Parcelable{

    private int subclassAge;
    private String subclassName;

    public ParcelableSubclassEntity(){

    }


    protected ParcelableSubclassEntity(Parcel in) {
        parentAge=in.readInt();
        parentName=in.readString();
        subclassAge = in.readInt();
        subclassName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(parentAge);
        dest.writeString(parentName);
        dest.writeInt(subclassAge);
        dest.writeString(subclassName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ParcelableSubclassEntity> CREATOR = new Creator<ParcelableSubclassEntity>() {
        @Override
        public ParcelableSubclassEntity createFromParcel(Parcel in) {
            return new ParcelableSubclassEntity(in);
        }

        @Override
        public ParcelableSubclassEntity[] newArray(int size) {
            return new ParcelableSubclassEntity[size];
        }
    };

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
