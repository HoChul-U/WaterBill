package com.nhnacademy.springboot.hochul.repository;

import java.util.Comparator;

public class Sorted implements Comparator<WaterBill> {
    @Override
    public int compare(WaterBill o1, WaterBill o2) {
        if(o1.getTotalBill() >= o2.getTotalBill()) return 1;
        else if(o1.getTotalBill() < o2.getTotalBill()) return -1;

        return 0;
    }
}
