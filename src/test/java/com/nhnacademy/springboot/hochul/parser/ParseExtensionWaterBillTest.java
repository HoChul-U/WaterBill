package com.nhnacademy.springboot.hochul.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.nhnacademy.springboot.hochul.parser.ParseExtensionWaterBill;
import com.nhnacademy.springboot.hochul.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseExtensionWaterBillTest {

    Parser parser = new ParseExtensionWaterBill();

    @DisplayName("load 후 findAll 실행시 json 데이터 로드")
    @Test
    void load() {
        parser.load();
        assertThat(parser.findAll()).isNotEmpty();
        parser.findAll().clear();
    }

    @DisplayName("load 전 findAll 실행시 예외 발생")
    @Test
    void findAll() {
        assertThatThrownBy(() -> parser.findAll())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Load first");
    }
}