package com.example.ruxing.serializationpractice.entity;

import java.io.Serializable;

/**
 * Created by ruxing on 2018/11/28.
 */

public class SerializableEntity implements Serializable{

    private static final long serialVersionUID = -1177331031212835616L;
    private byte b;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;
    private boolean b2;
    private char c;

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    public short getS() {
        return s;
    }

    public void setS(short s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
