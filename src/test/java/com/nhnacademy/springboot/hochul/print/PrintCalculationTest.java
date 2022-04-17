package com.nhnacademy.springboot.hochul.print;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.nhnacademy.springboot.hochul.parser.ParseCsvWaterBill;
import com.nhnacademy.springboot.hochul.parser.Parser;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PrintCalculationTest {
    Print print = spy(new PrintCalculation());
    Parser tariff = ParseCsvWaterBill.getInstance();

    @Test
    void printWaterBill() throws IOException {
        tariff.load();
        print.printWaterBill(tariff.findAll());
        verify(print, times(1)).printWaterBill(any());
    }
}