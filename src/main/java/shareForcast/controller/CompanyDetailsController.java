package shareForcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.CompanyDetails;

@RestController
public class CompanyDetailsController {

    @RequestMapping(value="/companyDetails", method= RequestMethod.GET)
    public CompanyDetails getCompanyDetails(@RequestParam(value = "companyId") int companyId) {
        return new CompanyDetails("ONGC comapnyId = " + companyId + "from server");
    }
}