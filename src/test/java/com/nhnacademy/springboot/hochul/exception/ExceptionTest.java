package com.nhnacademy.springboot.hochul.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.nhnacademy.springboot.hochul.parser.ParseCsvWaterBill;
import com.nhnacademy.springboot.hochul.parser.ParseJsonWaterBill;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionTest {

    ParseJsonWaterBill jsonWaterBill = ParseJsonWaterBill.getInstance();
    ParseCsvWaterBill csvWaterBill = ParseCsvWaterBill.getInstance();

    @DisplayName("JsonWaterBill load 전 메소드 실행시 예외 발생")
    @Test
    void jsonWaterBillException() {
        jsonWaterBill.clear();
        assertThatThrownBy(jsonWaterBill::findAll)
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Load first");
    }

    @DisplayName("FindAll 실행시 예외 발생")
    @Test
    void findAllExceptionTest() {
        csvWaterBill.clear();
        assertThatThrownBy(csvWaterBill::findAll)
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Load first");
    }

}
