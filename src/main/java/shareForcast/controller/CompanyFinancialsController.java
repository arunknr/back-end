package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.BalanceSheetAttributeValues;
import shareForcast.services.BalanceSheetService;

import java.util.List;

@RestController
public class CompanyFinancialsController {

    private BalanceSheetService balanceSheetService;

    @Autowired
    public CompanyFinancialsController(BalanceSheetService balanceSheetService) {
        this.balanceSheetService = balanceSheetService;
    }

    @RequestMapping(value="/companyBalanceSheet", method= RequestMethod.GET)
    public List<BalanceSheetAttributeValues> getCompanyBalanceSheet(@RequestParam(value = "companyId") int companyId) {
        return balanceSheetService.getAll(companyId);
    }
}