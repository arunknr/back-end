package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.CashFlowValuesDAO;

import java.util.HashMap;
import java.util.List;

@Component
public class CashFlowService {
    private CashFlowValuesDAO cashFlowValuesDAO;

    @Autowired
    public CashFlowService(CashFlowValuesDAO cashFlowValuesDAO) {
        this.cashFlowValuesDAO = cashFlowValuesDAO;
    }

    public List<HashMap<String, Object>> getAll(int companyId, int reportPeriod) {
        return cashFlowValuesDAO.getAll(companyId, reportPeriod);
    }
}
