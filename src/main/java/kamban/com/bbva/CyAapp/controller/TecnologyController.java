package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.TechnologyModel;
import kamban.com.bbva.CyAapp.service.TecnologyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tecnologia")
public class TecnologyController {

    @Autowired
    private TecnologyAppService _TecnologyAppService;

    @RequestMapping("/")
    public String indexView(Model model){
        model.addAttribute("responseData",_TecnologyAppService.getAll());

        return "tecnologia/index";
    }

    @RequestMapping("/create")
    public String createView(Model model){
        model.addAttribute("technology",new TechnologyModel());
        return "tecnologia/Create";
    }

    @RequestMapping("/alter")
    public String alterView(@RequestParam("id") String id,Model model){
        ResponseDataModel<TechnologyModel> responseService=_TecnologyAppService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "tecnologia/Alter";
    }


    /*
      > Servicios de eventos en formularios
   */
    @PostMapping("/")
    public String createTechnology(@ModelAttribute("technology") TechnologyModel technologyModel, Model model){
        ResponseDataModel<TechnologyModel> responseService=_TecnologyAppService.create(technologyModel);
        if(responseService.getCode().equals("0")){
            return "redirect:/tecnologia/";
        }else{
            responseService.setResult(technologyModel);
            model.addAttribute("responseData",responseService);
            return "tecnologia/Create";
        }
    }
    @PostMapping("/update")
    public String updateTechnology(@ModelAttribute("modalData") TechnologyModel technologyModel,Model model){
        ResponseDataModel<TechnologyModel> responseService=_TecnologyAppService.alter(technologyModel);;
        if(responseService.getCode().equals("0")){
            return "redirect:/tecnologia/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",technologyModel);
            model.addAttribute("responseData",responseService);
            return "tecnologia/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<TechnologyModel> disableTechnology(@RequestParam("id") String id, Model model){
        return _TecnologyAppService.processDelete(id);
    }

}
