package com.nhnacademy.springboot.hochul;

import com.nhnacademy.springboot.hochul.config.MainConfiguration;
import com.nhnacademy.springboot.hochul.print.Print;
import com.nhnacademy.springboot.hochul.parser.Parser;
import com.nhnacademy.springboot.hochul.service.PayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(MainConfiguration.class)) {
            var waterBill = context.getBean("parseExtensionWaterBill", Parser.class);
            var service = context.getBean("waterBillService", PayService.class);
            var print = context.getBean("printCalculation", Print.class);

            waterBill.load();
            print.printWaterBill(service.cal(1000, waterBill.findAll()));
            print.printWaterBill(service.cal(2000, waterBill.findAll()));
            print.printWaterBill(service.cal(3000,waterBill.findAll()));
        }
    }
}
