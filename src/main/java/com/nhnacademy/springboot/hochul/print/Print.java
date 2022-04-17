package com.nhnacademy.springboot.hochul.print;

import com.nhnacademy.springboot.hochul.repository.WaterBill;
import java.util.List;

public interface Print {
    void printWaterBill(List<WaterBill> list);
}
