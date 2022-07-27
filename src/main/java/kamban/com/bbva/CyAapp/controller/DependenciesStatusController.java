package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.DependencyStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.DependencyStatusAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estDep")
public class DependenciesStatusController {

    @Autowired
    private DependencyStatusAppService _DependencyStsAppService;

    @RequestMapping("/")
    public String indexView(Model model){
        model.addAttribute("responseData",_DependencyStsAppService.getAll());

        return "estDep/index";
    }

    @RequestMapping("/create")
    public String createView(Model model){
        model.addAttribute("modalData",new DependencyStatusModel());
        return "estDep/Create";
    }

    @RequestMapping("/alter")
    public String alterView(@RequestParam("id") String id, Model model){
        ResponseDataModel<DependencyStatusModel> responseService=_DependencyStsAppService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "estDep/Alter";
    }


    /*
      > Servicios de eventos en formularios
   */
    @PostMapping("/")
    public String createEstDep(@ModelAttribute("modalData") DependencyStatusModel stsDependenciModel, Model model){
        ResponseDataModel<DependencyStatusModel> responseService=_DependencyStsAppService.create(stsDependenciModel);
        if(responseService.getCode().equals("0")){
            return "redirect:/estDep/";
        }else{
            responseService.setResult(stsDependenciModel);
            model.addAttribute("responseData",responseService);
            return "estDep/Create";
        }
    }
    @PostMapping("/update")
    public String updateEstDep(@ModelAttribute("modalData") DependencyStatusModel stsDependenciModel,Model model){
        ResponseDataModel<DependencyStatusModel> responseService=_DependencyStsAppService.alter(stsDependenciModel);;
        if(responseService.getCode().equals("0")){
            return "redirect:/estDep/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",stsDependenciModel);
            model.addAttribute("responseData",responseService);
            return "estDep/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<DependencyStatusModel> disableEstDep(@RequestParam("id") String id, Model model){
        return _DependencyStsAppService.processDelete(id);
    }
}
