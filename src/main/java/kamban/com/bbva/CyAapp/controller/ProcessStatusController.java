package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.DependencyStatusModel;
import kamban.com.bbva.CyAapp.model.ProcessStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.ProcessStatusAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estProc")
public class ProcessStatusController {

    @Autowired
    private ProcessStatusAppService _processStsAppService;

    @RequestMapping("/")
    public String indexView(Model model){
        model.addAttribute("responseData",_processStsAppService.getAll());

        return "estProc/index";
    }

    @RequestMapping("/create")
    public String createView(Model model){
        model.addAttribute("modalData",new ProcessStatusModel());
        return "estProc/Create";
    }

    @RequestMapping("/alter")
    public String alterView(@RequestParam("id") String id, Model model){
        ResponseDataModel<ProcessStatusModel> responseService=_processStsAppService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "estProc/Alter";
    }


    /*
      > Servicios de eventos en formularios
   */
    @PostMapping("/")
    public String createEstProc(@ModelAttribute("modalData") ProcessStatusModel stsProcModel, Model model){
        ResponseDataModel<ProcessStatusModel> responseService=_processStsAppService.create(stsProcModel);
        if(responseService.getCode().equals("0")){
            return "redirect:/estProc/";
        }else{
            responseService.setResult(stsProcModel);
            model.addAttribute("responseData",responseService);
            return "estProc/Create";
        }
    }
    @PostMapping("/update")
    public String updateEstProc(@ModelAttribute("modalData") ProcessStatusModel stsProcModel,Model model){
        ResponseDataModel<ProcessStatusModel> responseService=_processStsAppService.alter(stsProcModel);;
        if(responseService.getCode().equals("0")){
            return "redirect:/estProc/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",stsProcModel);
            model.addAttribute("responseData",responseService);
            return "estProc/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<ProcessStatusModel> disableEstProc(@RequestParam("id") String id, Model model){
        return _processStsAppService.processDelete(id);
    }
}
