package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.BalanceSheetValuesDAO;
import shareForcast.model.BalanceSheetAttributeValues;

import java.util.List;

@Component
public class BalanceSheetService {
    private BalanceSheetValuesDAO balanceSheetValuesDAO;

    @Autowired
    public BalanceSheetService(BalanceSheetValuesDAO balanceSheetValuesDAO) {
        this.balanceSheetValuesDAO = balanceSheetValuesDAO;
    }

    public List<BalanceSheetAttributeValues> getAll(int companyId) {
        return balanceSheetValuesDAO.getAll(companyId);
    }
}
