package com.keshav.mobius.model;

public class Slab {
    public String name;
    public int num;
    public double min;
    public double max;
    public double wagered_percent;
    public double wagered_max;
    public double otc_percent;
    public double otc_max;

    public Slab(String name, int num, double min, double max, double wagered_percent, double wagered_max, double otc_percent, double otc_max) {
        this.name = name;
        this.num = num;
        this.min = min;
        this.max = max;
        this.wagered_percent = wagered_percent;
        this.wagered_max = wagered_max;
        this.otc_percent = otc_percent;
        this.otc_max = otc_max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getWagered_percent() {
        return wagered_percent;
    }

    public void setWagered_percent(double wagered_percent) {
        this.wagered_percent = wagered_percent;
    }

    public double getWagered_max() {
        return wagered_max;
    }

    public void setWagered_max(double wagered_max) {
        this.wagered_max = wagered_max;
    }

    public double getOtc_percent() {
        return otc_percent;
    }

    public void setOtc_percent(double otc_percent) {
        this.otc_percent = otc_percent;
    }

    public double getOtc_max() {
        return otc_max;
    }

    public void setOtc_max(double otc_max) {
        this.otc_max = otc_max;
    }
}
