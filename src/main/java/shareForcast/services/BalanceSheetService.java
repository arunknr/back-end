package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.BalanceSheetValuesDAO;

import java.util.HashMap;
import java.util.List;

@Component
public class BalanceSheetService {
    private BalanceSheetValuesDAO balanceSheetValuesDAO;

    @Autowired
    public BalanceSheetService(BalanceSheetValuesDAO balanceSheetValuesDAO) {
        this.balanceSheetValuesDAO = balanceSheetValuesDAO;
    }

    public List<HashMap<String, Object>> getAll(int companyId, int reportPeriod) {
        return balanceSheetValuesDAO.getAll(companyId, reportPeriod);
    }
}
