package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.CompanyInfo;
import shareForcast.services.CompanyInfoService;

@RestController
public class CompanyDetailsController {

    private CompanyInfoService companyInfoService;

    @Autowired
    public CompanyDetailsController(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    @RequestMapping(value="/companyDetails", method= RequestMethod.GET)
    public CompanyInfo getCompanyDetails(@RequestParam(value = "companyId") int companyId) {
        return companyInfoService.get(companyId);
    }
}