package shareForcast.helper;

import org.springframework.stereotype.Component;
import shareForcast.model.ProfitLossAttributeValues;
import shareForcast.model.ProfitLossAttributeValuesPk;
import shareForcast.model.ProfitLossAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ProfitLossValueResponseTransformer {

    public static List<HashMap<String, Object>> processResponseForProfitLossValueQuery(List<ProfitLossAttributeValues> profitLossValues) {
        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> hashMapList = new ArrayList<>();
        int i = 0, firstIteration = 0;
        ProfitLossAttributes oldValue = new ProfitLossAttributes();
        for (ProfitLossAttributeValues profitLossValue : profitLossValues) {
            ProfitLossAttributeValuesPk idValue =  profitLossValue.getId();
            ProfitLossAttributes currentValue = idValue.getId();
            if (firstIteration == 0){
                oldValue = currentValue;
                firstIteration =1;
            }
            if (currentValue.equals(oldValue)) {
                map.put(String.valueOf(i), (Object) profitLossValue);
                i++;
            } else {
                hashMapList.add(map);
                map = new HashMap<>();
                map.put(String.valueOf(0), (Object) profitLossValue);
                oldValue = currentValue;
                i = 1;
            }
        }
        hashMapList.add(map);
        return hashMapList;
    }
}
