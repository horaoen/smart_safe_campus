package com.horaoen.smart_safe_campus.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class StringUtil {
    public static List<UUID> StringToUUIDs(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        List<UUID> res = new ArrayList<>();
        idList.forEach(id -> {
            UUID uuid = UUID.fromString(id);
            res.add(uuid);
        });
        return res;
    }
}
