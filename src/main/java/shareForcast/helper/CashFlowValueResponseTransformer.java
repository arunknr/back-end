package shareForcast.helper;

import org.springframework.stereotype.Component;
import shareForcast.model.CashFlowAttributeValues;
import shareForcast.model.CashFlowAttributeValuesPk;
import shareForcast.model.CashFlowAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CashFlowValueResponseTransformer {

    public static List<HashMap<String, Object>> processResponseForCashFlowValueQuery(List<CashFlowAttributeValues> cashFlowValues) {
        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> hashMapList = new ArrayList<>();
        int i = 0, firstIteration = 0;
        CashFlowAttributes oldValue = new CashFlowAttributes();
        for (CashFlowAttributeValues cashFlowValue : cashFlowValues) {
            CashFlowAttributeValuesPk idValue =  cashFlowValue.getId();
            CashFlowAttributes currentValue = idValue.getId();
            if (firstIteration == 0){
                oldValue = currentValue;
                firstIteration =1;
            }
            if (currentValue.equals(oldValue)) {
                map.put(String.valueOf(i), (Object) cashFlowValue);
                i++;
            } else {
                hashMapList.add(map);
                map = new HashMap<>();
                map.put(String.valueOf(0), (Object) cashFlowValue);
                oldValue = currentValue;
                i = 1;
            }
        }
        hashMapList.add(map);
        return hashMapList;
    }
}
