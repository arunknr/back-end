package shareForcast.helper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class RatiovalueResponseTransformer {

    public static List<HashMap<String, String>> processResponseForRatioValueQuery(List<String> keys, List listOfRatioValues) {
        HashMap<String, String> map = new HashMap<>();
        List<HashMap<String, String>> hashMapList = new ArrayList<>();
        int i = 2;
        for (Object ratioValue : listOfRatioValues) {
            Object[] value = (Object[]) ratioValue;
            if (i == 2) {
                map = new HashMap<>();
                map.put(keys.get(0), value[0].toString());
                map.put(keys.get(1), value[1].toString());
            }
            map.put(keys.get(i), value[2].toString());
            i++;
            map.put(keys.get(i), value[3].toString());
            i++;
            if (i == keys.size()) {
                hashMapList.add(map);
                i = 2;
            }
        }
        return hashMapList;
    }
}
