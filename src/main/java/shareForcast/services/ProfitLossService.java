package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.ProfitLossValuesDAO;
import shareForcast.model.ProfitLossAttributeValues;

import java.util.List;

@Component
public class ProfitLossService {
    private ProfitLossValuesDAO profitLossValuesDAO;

    @Autowired
    public ProfitLossService(ProfitLossValuesDAO profitLossValuesDAO) {
        this.profitLossValuesDAO = profitLossValuesDAO;
    }

    public List<ProfitLossAttributeValues> getAll(int companyId) {
        return profitLossValuesDAO.getAll(companyId);
    }
}
