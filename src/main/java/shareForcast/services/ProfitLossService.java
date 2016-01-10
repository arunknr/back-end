package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.ProfitLossValuesDAO;

import java.util.HashMap;
import java.util.List;

@Component
public class ProfitLossService {
    private ProfitLossValuesDAO profitLossValuesDAO;

    @Autowired
    public ProfitLossService(ProfitLossValuesDAO profitLossValuesDAO) {
        this.profitLossValuesDAO = profitLossValuesDAO;
    }

    public List<HashMap<String, Object>> getAll(int companyId, int reportPeriod) {
        return profitLossValuesDAO.getAll(companyId, reportPeriod);
    }
}
