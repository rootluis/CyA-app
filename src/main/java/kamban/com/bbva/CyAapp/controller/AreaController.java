package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.AreaModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.AreaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaAppService _areaService;

    /*
        > Servicios de mapeo de formularios
     */
    @RequestMapping("/")
    public String indexArea(Model model){
        model.addAttribute("responseData",_areaService.getAll());
        return "area/index";

    }
    @RequestMapping("/create")
    public String createArea(Model model){
        model.addAttribute("area",new AreaModel());
        return "area/Create";
    }
    @RequestMapping("/alter")
    public String alterArea(@RequestParam("id") String id,Model model){
        ResponseDataModel<AreaModel> responseService=_areaService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "area/Alter";
    }




    /*
        > Servicios de eventos en formularios
     */
    @PostMapping("/")
    public String createArea(@ModelAttribute("area") AreaModel areaModel,Model model){
        ResponseDataModel<AreaModel> responseService=_areaService.createArea(areaModel);
        if(responseService.getCode().equals("0")){
            return "redirect:/area/";
        }else{
            responseService.setResult(areaModel);
            model.addAttribute("responseData",responseService);
            return "area/Create";
        }
    }
    @PostMapping("/update")
    public String updateArea(@ModelAttribute("modalData") AreaModel areaModel,Model model){
        ResponseDataModel<AreaModel> responseService=_areaService.alterArea(areaModel);;
        if(responseService.getCode().equals("0")){
            return "redirect:/area/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",areaModel);
            model.addAttribute("responseData",responseService);
            return "area/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<AreaModel> disableArea(@RequestParam("id") String id, Model model){
        return _areaService.disabledArea(id);
    }
}
