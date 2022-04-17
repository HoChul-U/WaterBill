package com.nhnacademy.springboot.hochul.service;

import com.nhnacademy.springboot.hochul.repository.WaterBill;
import java.util.List;


public interface PayService {

    List<WaterBill> cal(long size, List<WaterBill> list);
}
