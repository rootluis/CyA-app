package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.service.AreaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private AreaAppService _areaAppService;

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("view","150.00");
        return "index";
    }

    @RequestMapping("/estatusDependencia")
    public String indexEstDep(Model model){
        return "estDep/index";
    }

    @RequestMapping("/processStatus")
    public String indexEstProc(Model model){
        return "estProc/index";
    }






}
