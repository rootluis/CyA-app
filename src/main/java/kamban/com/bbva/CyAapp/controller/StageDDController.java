package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.DDStageModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.DDStageAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/etapas")
public class StageDDController {

    @Autowired
    private DDStageAppService _staService;

    @RequestMapping("/")
    public String indexView(Model model){

        model.addAttribute("responseData",_staService.getAll());

        return "etapas/index";
    }

    @RequestMapping("/create")
    public String createView(Model model){
        model.addAttribute("modalData",new DDStageModel());
        return "etapas/Create";
    }

    @RequestMapping("/alter")
    public String alterView(@RequestParam("id") String id, Model model){
        ResponseDataModel<DDStageModel> responseService=_staService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "etapas/Alter";
    }


    /*
      > Servicios de eventos en formularios
   */
    @PostMapping("/")
    public String createContinuity(@ModelAttribute("modalData") DDStageModel stageModel, Model model){
        ResponseDataModel<DDStageModel> responseService=_staService.create(stageModel);
        if(responseService.getCode().equals("0")){
            return "redirect:/etapas/";
        }else{
            responseService.setResult(stageModel);
            model.addAttribute("responseData",responseService);
            return "etapas/Create";
        }
    }
    @PostMapping("/update")
    public String updateContinuity(@ModelAttribute("modalData") DDStageModel stageModel,Model model){
        ResponseDataModel<DDStageModel> responseService=_staService.alter(stageModel);;
        if(responseService.getCode().equals("0")){
            return "redirect:/etapas/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",stageModel);
            model.addAttribute("responseData",responseService);
            return "etapas/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<DDStageModel> disableContinuity(@RequestParam("id") String id, Model model){
        return _staService.processDelete(id);
    }


}
