package shareForcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.CompanyInfo;
import shareForcast.services.CompanyInfoService;

@RestController
public class CompanyDetailsController {

    @RequestMapping(value="/companyDetails", method= RequestMethod.GET)
    public CompanyInfo getCompanyDetails(@RequestParam(value = "accordId") int accordId, @RequestParam(value = "shianId") int shianId) {
        return new CompanyInfoService().get(accordId, shianId);
    }
}