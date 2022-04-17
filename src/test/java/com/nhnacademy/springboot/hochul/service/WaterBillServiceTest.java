package com.nhnacademy.springboot.hochul.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springboot.hochul.parser.ParseCsvWaterBill;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WaterBillServiceTest {

    PayService waterBillService = new WaterBillService();
    ParseCsvWaterBill csv = ParseCsvWaterBill.getInstance();

    @DisplayName("load 후 실행시 값출력")
    @Test
    void cal() {
        csv.clear();
        csv.load();
        assertThat(waterBillService.cal(5000, csv.findAll())).hasSize(103);
    }
}