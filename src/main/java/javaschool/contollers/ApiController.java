package javaschool.contollers;

import javaschool.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApiController {
    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @RequestMapping(value = "/api/admin/pdf", method = RequestMethod.GET)
    public ModelAndView createPdf() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("PdfRevenueSummary");

        modelAndView.addObject("productLongMap", statisticService.findTopTenProducts());
        modelAndView.addObject("clientLongMap", statisticService.findTopTenClients());
        modelAndView.addObject("ordersListDate", statisticService.ordersForAWeeks(1));


        return modelAndView;
    }
}
