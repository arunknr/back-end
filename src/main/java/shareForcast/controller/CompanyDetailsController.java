package shareForcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.CompanyInfo;

@RestController
public class CompanyDetailsController {

    @RequestMapping(value="/companyDetails", method= RequestMethod.GET)
    public CompanyInfo getCompanyDetails(@RequestParam(value = "companyId") int companyId) {
        return null;
    }
}