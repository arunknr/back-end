package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.services.CashFlowService;

import java.util.HashMap;
import java.util.List;

@RestController
public class CashFlowController {

    private CashFlowService cashFlowService;

    @Autowired
    public CashFlowController(CashFlowService cashFlowService) {
        this.cashFlowService = cashFlowService;
    }

    @RequestMapping(value="/companyCashFlow", method= RequestMethod.GET)
    public List<HashMap<String, Object>> getCompanyCashFlow(@RequestParam(value = "companyId") int companyId, @RequestParam(value = "reportPeriod") int reportPeriod) {
        return cashFlowService.getAll(companyId, reportPeriod);
    }
}