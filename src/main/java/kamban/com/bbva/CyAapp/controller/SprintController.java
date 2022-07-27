package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.SprintModel;
import kamban.com.bbva.CyAapp.service.SprintAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private SprintAppService _sprintAppService;

    @RequestMapping("/")
    public String indexView(Model model){
        model.addAttribute("responseData",_sprintAppService.getAll());

        return "sprint/index";
    }

    @RequestMapping("/create")
    public String createView(Model model){
        model.addAttribute("sprint",new SprintModel());
        return "sprint/Create";
    }

    @RequestMapping("/alter")
    public String alterView(@RequestParam("id") String id, Model model){
        ResponseDataModel<SprintModel> responseService=_sprintAppService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "sprint/Alter";
    }


    /*
      > Servicios de eventos en formularios
   */
    @PostMapping("/")
    public String createContinuity(@ModelAttribute("sprint") SprintModel sprintModel, Model model){
        ResponseDataModel<SprintModel> responseService=_sprintAppService.create(sprintModel);
        if(responseService.getCode().equals("0")){
            return "redirect:/sprint/";
        }else{
            responseService.setResult(sprintModel);
            model.addAttribute("responseData",responseService);
            return "sprint/Create";
        }
    }
    @PostMapping("/update")
    public String updateContinuity(@ModelAttribute("modalData") SprintModel sprintModel,Model model){
        ResponseDataModel<SprintModel> responseService=_sprintAppService.alter(sprintModel);;
        if(responseService.getCode().equals("0")){
            return "redirect:/sprint/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",sprintModel);
            model.addAttribute("responseData",responseService);
            return "sprint/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<SprintModel> disableContinuity(@RequestParam("id") String id, Model model){
        return _sprintAppService.processDelete(id);
    }


}
