package xyz.nyist.writerTest.futu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author: fucong
 * @Date: 2022/3/30 14:11
 * @Description:
 */
public class Main {

    public static String toMD5(Map<String, Object> map) {
        List<String> allKey = getAllKey(map, "");
        Collections.sort(allKey);

        StringBuilder sb = new StringBuilder();

        for (String key : allKey) {
            sb.append(key.toLowerCase()).append("=").append(getValue(map, key)).append(";");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static String getValue(Map<String, Object> map, String key) {
        if (!key.contains(".")) {
            return map.get(key).toString();
        }
        int index = key.indexOf(".");
        return getValue((Map<String, Object>) map.get(key.substring(0, index)), key.substring(index + 1));
    }

    @SuppressWarnings("unchecked")
    private static List<String> getAllKey(Map<String, Object> map, String preKey) {
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                res.addAll(getAllKey((Map<String, Object>) entry.getValue(), entry.getKey() + "."));
            } else {
                res.add(preKey + entry.getKey());
            }
        }
        return res;
    }

}
