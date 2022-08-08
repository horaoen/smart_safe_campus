package com.horaoen.smart_safe_campus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SmartSafeCampusApplicationTests {
    @Test
    public void testHashMap() {
        List<Map<String, Integer>> listedMap = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("1", 2);
        map1.put("2", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("3", 3);
        map2.put("4", 4);
        listedMap.add(map1);
        listedMap.add(map2);
        String key = "1";
        Integer value = 2;
        for (Map<String, Integer> map : listedMap) {
            if(map.get(key) == value) {
                listedMap.remove(map);
                System.out.println("success");
            }
        }
        for (Map<String, Integer> map : listedMap) {
            for ( Map.Entry<String, Integer>  entry : map.entrySet()) {
                System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            }
        }
    }
}
