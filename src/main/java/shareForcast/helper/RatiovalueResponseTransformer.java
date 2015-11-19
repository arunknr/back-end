package shareForcast.helper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class RatiovalueResponseTransformer {

    public static List<HashMap<String, String>> processResponseForRatioValueQuery(List<String> keys, List listOfRatioValues) {
        HashMap<String, String> map;
        List<HashMap<String, String>> hashMapList = new ArrayList<>();
        for (Object ratioValue : listOfRatioValues) {
            map = new HashMap<>();
            Object[] value = (Object[]) ratioValue;
            for(int i=0; i< keys.size(); i++){
                map.put(keys.get(i), value[i].toString());
            }
            hashMapList.add(map);
        }
        return hashMapList;
    }
}
