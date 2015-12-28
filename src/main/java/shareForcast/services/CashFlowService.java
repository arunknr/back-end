package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.CashFlowValuesDAO;
import shareForcast.model.CashFlowAttributeValues;

import java.util.List;

@Component
public class CashFlowService {
    private CashFlowValuesDAO cashFlowValuesDAO;

    @Autowired
    public CashFlowService(CashFlowValuesDAO cashFlowValuesDAO) {
        this.cashFlowValuesDAO = cashFlowValuesDAO;
    }

    public List<CashFlowAttributeValues> getAll(int companyId) {
        return cashFlowValuesDAO.getAll(companyId);
    }
}
