package shareForcast.helper;

import org.springframework.stereotype.Component;
import shareForcast.model.BalanceSheetAttributeValues;
import shareForcast.model.BalanceSheetAttributeValuesPk;
import shareForcast.model.BalanceSheetAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class BalanceSheetValueResponseTransformer {

    public static List<HashMap<String, Object>> processResponseForBalanceSheetValueQuery(List<BalanceSheetAttributeValues> balanceSheetValues) {
        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> hashMapList = new ArrayList<>();
        int i = 0, firstIteration = 0;
        BalanceSheetAttributes oldValue = new BalanceSheetAttributes();
        for (BalanceSheetAttributeValues balanceSheetValue : balanceSheetValues) {
            BalanceSheetAttributeValuesPk idValue =  balanceSheetValue.getId();
            BalanceSheetAttributes currentValue = idValue.getId();
            if (firstIteration == 0){
                oldValue = currentValue;
                firstIteration =1;
            }
            if (currentValue.equals(oldValue)) {
                map.put(String.valueOf(i), (Object) balanceSheetValue);
                i++;
            } else {
                hashMapList.add(map);
                map = new HashMap<>();
                map.put(String.valueOf(0), (Object) balanceSheetValue);
                oldValue = currentValue;
                i = 1;
            }
        }
        hashMapList.add(map);
        return hashMapList;
    }
}
