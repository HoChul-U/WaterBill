package com.nhnacademy.springboot.hochul.service;

import com.nhnacademy.springboot.hochul.repository.WaterBill;
import com.nhnacademy.springboot.hochul.repository.Sorted;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WaterBillService implements PayService {

    @Override
    public List<WaterBill> cal(long size, List<WaterBill> list) {
        ArrayList<WaterBill> localList = new ArrayList<>();
        sortLocalList(localList, size, list);
        localList.sort(new Sorted());
        return localList;
    }

    private List<WaterBill> sortLocalList(List<WaterBill> list, long size, Collection<WaterBill> governments) {
        for (WaterBill localGovernment : governments) {
            if (localGovernment.getEndSection() - size >= 0) {
                localGovernment.setTotalBill(localGovernment.getUnitPrice() * size);
                list.add(localGovernment);
            }
        }
        return list;
    }
}
