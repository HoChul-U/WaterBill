package com.nhnacademy.springboot.hochul.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springboot.hochul.repository.WaterBill;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class ParseJsonWaterBill implements Parser {

    private static final Log log = LogFactory.getLog(ParseJsonWaterBill.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    private List<WaterBill> repository = new ArrayList<>();

    private static final ParseJsonWaterBill INSTANCE = new ParseJsonWaterBill();

    private ParseJsonWaterBill() {

    }

    public static ParseJsonWaterBill getInstance() {
        return INSTANCE;
    }

    private boolean load = false;

    public void clear() {
        repository.clear();
        setLoad(false);
    }

    public void setLoad(boolean load) {
        this.load = load;
    }

    @Override
    public void load() {
        try (var buf = new BufferedReader(new InputStreamReader(parser(), StandardCharsets.UTF_8))) {
            var bufString = buf.lines().collect(Collectors.joining());
            log.debug(bufString);
            repository = mapper.readValue(bufString, new TypeReference<List<WaterBill>>() {
            });
            log.debug(repository);
        } catch (IOException e) {log.error("파일 문제");}
        setLoad(true);
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
        return this.getClass().getClassLoader().getResourceAsStream("data/Tariff_20220331.json");
    }
}
