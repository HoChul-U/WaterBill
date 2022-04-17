package com.nhnacademy.springboot.hochul.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.nhnacademy.springboot.hochul.parser.ParseJsonWaterBill;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseJsonWaterBillTest {
    ParseJsonWaterBill jsonWaterBill = ParseJsonWaterBill.getInstance();

    @DisplayName("load 시 값안비어있고 findAll 실행가능 ")
    @Test
    void findAllTest() {
        jsonWaterBill.clear();
        jsonWaterBill.load();
        assertThat(jsonWaterBill.findAll()).hasSize(303);
    }

    @DisplayName("clear 시 저장소 값 초기화 값이 비어있어서 FindAll 시 예외 발생")
    @Test
    void clear() {
        jsonWaterBill.clear();
        jsonWaterBill.load();
        assertThat(jsonWaterBill.findAll()).isNotEmpty();
        jsonWaterBill.clear();
        assertThatThrownBy(() -> jsonWaterBill.findAll())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Load first");
    }
}