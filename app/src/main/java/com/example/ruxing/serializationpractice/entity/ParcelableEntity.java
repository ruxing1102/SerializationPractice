package com.example.ruxing.serializationpractice.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ruxing on 2018/11/28.
 */

public class ParcelableEntity implements Parcelable {

    private byte byteData;
    private short shortData;
    private int intData;
    private long longData;
    private float floatData;
    private double doubleData;
    private char charData;
    private boolean booleanData;
    private String stringData;
    private BigDecimal bigDecimalData;
    private OuterEntity outerEntity;
    private List<OuterEntity> outerList;
    private InnerEntity innerEntity;
    private List<InnerEntity> innerList;
    private Map<String, OuterEntity> map1;
    private Map<Integer, List<OuterEntity>> map2;

    public ParcelableEntity() {

    }


    protected ParcelableEntity(Parcel in) {
        byteData = in.readByte();
        shortData = (short) in.readInt();
        intData = in.readInt();
        longData = in.readLong();
        floatData = in.readFloat();
        doubleData = in.readDouble();
        charData = (char) in.readInt();
        booleanData = in.readByte() != 0;
        stringData = in.readString();
        bigDecimalData=new BigDecimal(in.readString());
        outerEntity = in.readParcelable(OuterEntity.class.getClassLoader());
        outerList = in.createTypedArrayList(OuterEntity.CREATOR);
        innerEntity = in.readParcelable(InnerEntity.class.getClassLoader());
        innerList = in.createTypedArrayList(InnerEntity.CREATOR);
        if (map1 == null) map1 = new HashMap<>();
        int map1Size = in.readInt();
        if (map1Size > 0) {
            for (int i = 0; i < map1Size; i++) {
                String key = in.readString();
                OuterEntity value = in.readParcelable(OuterEntity.class.getClassLoader());
                map1.put(key, value);
            }
        }
        if (map2 == null) map2 = new HashMap<>();
        int map2Size = in.readInt();
        if (map2Size > 0) {
            for (int i = 0; i < map2Size; i++) {
                Integer key = in.readInt();
                List<OuterEntity> value = in.createTypedArrayList(OuterEntity.CREATOR);
                map2.put(key, value);
            }
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(byteData);
        dest.writeInt((int) shortData);
        dest.writeInt(intData);
        dest.writeLong(longData);
        dest.writeFloat(floatData);
        dest.writeDouble(doubleData);
        dest.writeInt((int) charData);
        dest.writeByte((byte) (booleanData ? 1 : 0));
        dest.writeString(stringData);
        dest.writeString(bigDecimalData == null ? "0" : bigDecimalData.toString());
        dest.writeParcelable(outerEntity, flags);
        dest.writeTypedList(outerList);
        dest.writeParcelable(innerEntity, flags);
        dest.writeTypedList(innerList);
        if (null != map1 && map1.size() > 0) {
            dest.writeInt(map1.size());//先写入map的大小
            for (Map.Entry<String, OuterEntity> entry : map1.entrySet()) {
                dest.writeString(entry.getKey());
                dest.writeParcelable(entry.getValue(), flags);
            }
        }
        if (null != map2 && map2.size() > 0) {
            dest.writeInt(map2.size());
            for (Map.Entry<Integer, List<OuterEntity>> entry : map2.entrySet()) {
                dest.writeInt(entry.getKey());
                dest.writeTypedList(entry.getValue());
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ParcelableEntity> CREATOR = new Creator<ParcelableEntity>() {
        @Override
        public ParcelableEntity createFromParcel(Parcel in) {
            return new ParcelableEntity(in);
        }

        @Override
        public ParcelableEntity[] newArray(int size) {
            return new ParcelableEntity[size];
        }
    };

    public byte getByteData() {
        return byteData;
    }

    public void setByteData(byte byteData) {
        this.byteData = byteData;
    }

    public short getShortData() {
        return shortData;
    }

    public void setShortData(short shortData) {
        this.shortData = shortData;
    }

    public int getIntData() {
        return intData;
    }

    public void setIntData(int intData) {
        this.intData = intData;
    }

    public long getLongData() {
        return longData;
    }

    public void setLongData(long longData) {
        this.longData = longData;
    }

    public float getFloatData() {
        return floatData;
    }

    public void setFloatData(float floatData) {
        this.floatData = floatData;
    }

    public double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(double doubleData) {
        this.doubleData = doubleData;
    }

    public char getCharData() {
        return charData;
    }

    public void setCharData(char charData) {
        this.charData = charData;
    }

    public boolean isBooleanData() {
        return booleanData;
    }

    public void setBooleanData(boolean booleanData) {
        this.booleanData = booleanData;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    public BigDecimal getBigDecimalData() {
        return bigDecimalData;
    }

    public void setBigDecimalData(BigDecimal bigDecimalData) {
        this.bigDecimalData = bigDecimalData;
    }

    public OuterEntity getOuterEntity() {
        return outerEntity;
    }

    public void setOuterEntity(OuterEntity outerEntity) {
        this.outerEntity = outerEntity;
    }

    public List<OuterEntity> getOuterList() {
        return outerList;
    }

    public void setOuterList(List<OuterEntity> outerList) {
        this.outerList = outerList;
    }

    public InnerEntity getInnerEntity() {
        return innerEntity;
    }

    public void setInnerEntity(InnerEntity innerEntity) {
        this.innerEntity = innerEntity;
    }

    public List<InnerEntity> getInnerList() {
        return innerList;
    }

    public void setInnerList(List<InnerEntity> innerList) {
        this.innerList = innerList;
    }

    public Map<String, OuterEntity> getMap1() {
        return map1;
    }

    public void setMap1(Map<String, OuterEntity> map1) {
        this.map1 = map1;
    }

    public Map<Integer, List<OuterEntity>> getMap2() {
        return map2;
    }

    public void setMap2(Map<Integer, List<OuterEntity>> map2) {
        this.map2 = map2;
    }

    public static class InnerEntity implements Parcelable {
        private String name;
        private int age;

        public InnerEntity() {
        }

        protected InnerEntity(Parcel in) {
            name = in.readString();
            age = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeInt(age);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<InnerEntity> CREATOR = new Creator<InnerEntity>() {
            @Override
            public InnerEntity createFromParcel(Parcel in) {
                return new InnerEntity(in);
            }

            @Override
            public InnerEntity[] newArray(int size) {
                return new InnerEntity[size];
            }
        };

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
