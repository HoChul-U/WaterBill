package com.nhnacademy.springboot.hochul.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WaterBillTest {

    @Test
    void setTotalBill() {
        WaterBill government = new WaterBill("a", "b", 10, 0);
        assertThat(government.getTotalBill()).isZero();
        government.setTotalBill(10);
        assertThat(government.getTotalBill()).isEqualTo(10);
    }
}