package com.nhnacademy.springboot.hochul.parser;

import com.nhnacademy.springboot.hochul.repository.WaterBill;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/*
 *  순번 , 지자체명 , 업종 , 단계 , 구간시작(세제곱미터)  , 구간끝(세제곱미터)  , 구간금액(원)  , 단계별 기본요금(원)
 *
 * 지자체명 / 업종 /구간금액 / 입력값 * 구간금액
 *
 * */
@Service
public class ParseCsvWaterBill implements Parser {

    private static final Log log = LogFactory.getLog(ParseCsvWaterBill.class);

    private static final List<WaterBill> repository = new ArrayList<>();

    private static final ParseCsvWaterBill INSTANCE = new ParseCsvWaterBill();

    private ParseCsvWaterBill() {
    }

    public void clear() {
        repository.clear();
        setLoad(false);
    }

    private boolean load = false;

    public void setLoad(boolean load) {
        this.load = load;
    }

    public static ParseCsvWaterBill getInstance() {
        return INSTANCE;
    }

    @Override
    public List<WaterBill> findAll() {
        if (!load) {
            throw new IllegalStateException("Load first");
        }
        return repository;
    }

    @Override
    public InputStream parser() {
        return getClass().getClassLoader().getResourceAsStream("data/Tariff_20220331.csv");
    }

    @Override
    public void load() {
        //csv 값들을 다 받는다.
        String line;
        try (var bufferedReader = new BufferedReader(
            new InputStreamReader(parser(), StandardCharsets.UTF_8))) {
            bufferedReader.lines().skip(0).findFirst();
            while ((line = bufferedReader.readLine()) != null) {
                String[] field = line.split(",");
                repository.add(new WaterBill(field[1], field[2], Integer.parseInt(field[5]),
                    Integer.parseInt(field[6])));
            }
        } catch (IOException e) {log.error("Ops!", e);}
        setLoad(true);
    }
}
