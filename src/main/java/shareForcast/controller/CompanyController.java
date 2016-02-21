package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.reqResModels.CompanyResponse;
import shareForcast.services.CompanyService;

@RestController
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value="/companies", method= RequestMethod.GET)
    public CompanyResponse fetchCompany() {
        return new CompanyResponse(companyService.fetch());
    }
}
