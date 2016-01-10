package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.services.BalanceSheetService;

import java.util.HashMap;
import java.util.List;

@RestController
public class BalanceSheetController {

    private BalanceSheetService balanceSheetService;

    @Autowired
    public BalanceSheetController(BalanceSheetService balanceSheetService) {
        this.balanceSheetService = balanceSheetService;
    }

    @RequestMapping(value="/companyBalanceSheet", method= RequestMethod.GET)
    public List<HashMap<String, Object>> getCompanyBalanceSheet(@RequestParam(value = "companyId") int companyId, @RequestParam(value = "reportPeriod") int reportPeriod) {
        return balanceSheetService.getAll(companyId, reportPeriod);
    }
}