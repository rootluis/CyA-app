package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.ContinuityModel;
import kamban.com.bbva.CyAapp.model.MDLDisciplina;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.ContinuityAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/continuidad")
public class ContinuityController {

    @Autowired
    private ContinuityAppService _contiAppService;
    @RequestMapping("/")
    public String indexView(Model model){
        model.addAttribute("responseData",_contiAppService.getAll());

        return "continuity/index";
    }

    @RequestMapping("/create")
    public String createView(Model model){
        model.addAttribute("continuity",new ContinuityModel());
        return "continuity/Create";
    }

    @RequestMapping("/alter")
    public String alterView(@RequestParam("id") String id, Model model){
        ResponseDataModel<ContinuityModel> responseService=_contiAppService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "continuity/Alter";
    }


    /*
      > Servicios de eventos en formularios
   */
    @PostMapping("/")
    public String createContinuity(@ModelAttribute("continuity") ContinuityModel continuityModel, Model model){
        ResponseDataModel<ContinuityModel> responseService=_contiAppService.create(continuityModel);
        if(responseService.getCode().equals("0")){
            return "redirect:/continuidad/";
        }else{
            responseService.setResult(continuityModel);
            model.addAttribute("responseData",responseService);
            return "continuity/Create";
        }
    }
    @PostMapping("/update")
    public String updateContinuity(@ModelAttribute("modalData") ContinuityModel continuityModel,Model model){
        ResponseDataModel<ContinuityModel> responseService=_contiAppService.alter(continuityModel);;
        if(responseService.getCode().equals("0")){
            return "redirect:/continuidad/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",continuityModel);
            model.addAttribute("responseData",responseService);
            return "continuity/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<ContinuityModel> disableContinuity(@RequestParam("id") String id, Model model){
        return _contiAppService.processDelete(id);
    }



}
