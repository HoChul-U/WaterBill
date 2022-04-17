package com.nhnacademy.springboot.hochul.print;

import com.nhnacademy.springboot.hochul.repository.WaterBill;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;


@Service
public class PrintCalculation implements Print {

    private static final Log log = LogFactory.getLog(PrintCalculation.class);
    @Override
    public void printWaterBill(List<WaterBill> list) {
        for (var i = 0; i < 5; i++) {
            log.info(list.get(i).toString());
        }
    }
}
