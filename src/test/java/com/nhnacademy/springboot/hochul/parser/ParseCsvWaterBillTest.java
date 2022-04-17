package com.nhnacademy.springboot.hochul.parser;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.nhnacademy.springboot.hochul.parser.ParseCsvWaterBill;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseCsvWaterBillTest {

    ParseCsvWaterBill csvWaterBill = ParseCsvWaterBill.getInstance();

    @DisplayName("load 시 값안비어있고 findAll 실행가능 ")
    @Test
    void findAllTest() {
        csvWaterBill.clear();
        csvWaterBill.load();
        assertThat(csvWaterBill.findAll()).isNotEmpty();
    }

    @DisplayName("clear 시 저장소 값 초기화 값이 비어있어서 FindAll 시 예외 발생")
    @Test
    void clear() {
        csvWaterBill.clear();
        csvWaterBill.load();
        assertThat(csvWaterBill.findAll()).isNotEmpty();
        csvWaterBill.clear();
        assertThatThrownBy(() -> csvWaterBill.findAll())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Load first");
    }
}