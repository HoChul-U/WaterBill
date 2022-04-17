package com.nhnacademy.springboot.hochul.repository;

import java.beans.ConstructorProperties;

/// 지자체명 , 업종 , 단계 , 구간시작(세제곱미터)  , 구간끝(세제곱미터)  , 구간금액(원)  , 단계별 기본요금(원)
public class WaterBill {
    private static final long ZERO = 0;
    //지자체명
    private final String localGovernmentName;
    //업종
    private final String typeofBusiness;
    //단계
    private final long level;
    //순번
    private final long seq;
    //구간시작
    private final long startSection;
    //구간끝
    private final long endSection;
    //구간금액
    private final long unitPrice;
    //단계별 기본요금(원)
    private final String levelMoney;
    //총합금액
    private long totalBill;

    @ConstructorProperties({"순번", "지자체명", "업종", "단계", "구간시작(세제곱미터)", "구간끝(세제곱미터)", "구간금액(원)", "단계별 기본요금(원)"})
    public WaterBill(long seq, String localGovernmentName, String typeofBusiness, long level,
                     long startSection, long endSection, long unitPrice, String levelMoney) {
        this.localGovernmentName = localGovernmentName;
        this.typeofBusiness = typeofBusiness;
        this.level = level;
        this.seq = seq;
        this.startSection = startSection;
        this.endSection = endSection;
        this.unitPrice = unitPrice;
        this.levelMoney = levelMoney;
        this.totalBill = ZERO;
    }

    //아래 생성자 건들면 출력문 날아감
    public WaterBill(String localGovernmentName, String typeofBusiness, long endSection, long unitPrice) {
        this(ZERO, localGovernmentName, typeofBusiness, ZERO, ZERO, endSection, unitPrice, "");
    }

    public void setTotalBill(long totalBill) {
        this.totalBill = totalBill;
    }

    public long getTotalBill() {
        return totalBill;
    }

    public long getEndSection() {
        return endSection;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "WaterBill{" +
            "지자체명='" + localGovernmentName + '\'' +
            ", 업종='" + typeofBusiness + '\'' +
            ", 구간금액=" + unitPrice +
            ", 총합금액=" + totalBill +
            '}';
    }
}
