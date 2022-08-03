package com.horaoen.smart_safe_campus.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class StringUtil {
    public static List<String> StringToList(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));

        return idList;
    }
}
