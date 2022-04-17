package com.nhnacademy.springboot.hochul.parser;

import com.nhnacademy.springboot.hochul.repository.WaterBill;
import java.io.InputStream;
import java.util.List;
import org.springframework.stereotype.Service;

/*
 * 확장자에 따라서 CsvWaterBill 이나 JsonWaterBill 을 실행하는 클래스
 *  */

@Service
public class ParseExtensionWaterBill implements Parser {
    private static String extension = "json";

    Parser parser;

    List<WaterBill> waterBills;

    private boolean load = false;

    public void setLoad(boolean load) {
        this.load = load;
    }

    public boolean isLoad() {
        return load;
    }

    @Override
    public void load() {
        if (!(extension.equals("csv") || extension.equals("json"))) throw new IllegalArgumentException("fail extension");
        if (extension.equals("csv")) parser = ParseCsvWaterBill.getInstance();
        if (extension.equals("json")) parser = ParseJsonWaterBill.getInstance();

        parser.load();
        waterBills = parser.findAll();
        setLoad(true);
    }

    @Override
    public List<WaterBill> findAll() {
        if (!isLoad()) {
            throw new IllegalStateException("Load first");
        }
        return waterBills;
    }

    @Override
    public InputStream parser() {
        return null;
    }
}
