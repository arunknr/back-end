package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.services.ProfitLossService;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProfitLossController {

    private ProfitLossService profitLossService;

    @Autowired
    public ProfitLossController(ProfitLossService profitLossService) {
        this.profitLossService = profitLossService;
    }

    @RequestMapping(value="/companyProfitLoss", method= RequestMethod.GET)
    public List<HashMap<String, Object>> getCompanyProfitLoss(@RequestParam(value = "companyId") int companyId, @RequestParam(value = "reportPeriod") int reportPeriod) {
        return profitLossService.getAll(companyId, reportPeriod);
    }
}