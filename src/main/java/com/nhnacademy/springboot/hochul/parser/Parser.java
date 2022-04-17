package com.nhnacademy.springboot.hochul.parser;


import com.nhnacademy.springboot.hochul.repository.WaterBill;
import java.io.InputStream;
import java.util.List;

public interface Parser {

    void load();

    List<WaterBill> findAll();

    InputStream parser();

}
