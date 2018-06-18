package com.xiaoma.mvpdemo.model;

/**
 * Created by Administrator on 2018/6/2.
 */

public class TestEntry {
    private String a;
    private int b;
    private boolean c;

    public TestEntry() {
    }

    public TestEntry(String a, int b, boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }
}
