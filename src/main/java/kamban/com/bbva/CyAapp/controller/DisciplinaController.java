package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.appClients.DisciplinaAppClient;
import kamban.com.bbva.CyAapp.model.MDLDisciplina;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.DisciplinaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {


    /*
        > Servicios de mapeo de formularios
     */
    @Autowired
    private DisciplinaAppService _disciplineAppService;

    @RequestMapping("/")
    public String indexView(Model model){
        model.addAttribute("responseData",_disciplineAppService.getAll());

        return "disciplina/index";
    }

    @RequestMapping("/create")
    public String createView(Model model){
        model.addAttribute("discipline",new MDLDisciplina());
        return "disciplina/Create";
    }

    @RequestMapping("/alter")
    public String alterView(@RequestParam("id") String id,Model model){
        ResponseDataModel<MDLDisciplina> responseService=_disciplineAppService.getById(id);

        if(responseService.getCode().equals("0")){
            model.addAttribute("modalData",responseService.getResult());
        }

        model.addAttribute("responseData",responseService);

        return "disciplina/Alter";
    }


    /*
      > Servicios de eventos en formularios
   */
    @PostMapping("/")
    public String createDiscipline(@ModelAttribute("discipline") MDLDisciplina mdlDisciplina, Model model){
        ResponseDataModel<MDLDisciplina> responseService=_disciplineAppService.create(mdlDisciplina);
        if(responseService.getCode().equals("0")){
            return "redirect:/disciplina/";
        }else{
            responseService.setResult(mdlDisciplina);
            model.addAttribute("responseData",responseService);
            return "disciplina/Create";
        }
    }
    @PostMapping("/update")
    public String updateDiscipline(@ModelAttribute("modalData") MDLDisciplina mdlDisciplina,Model model){
        ResponseDataModel<MDLDisciplina> responseService=_disciplineAppService.alter(mdlDisciplina);;
        if(responseService.getCode().equals("0")){
            return "redirect:/disciplina/";
        }else{
            responseService.setCode("WEB-1");
            model.addAttribute("modalData",mdlDisciplina);
            model.addAttribute("responseData",responseService);
            return "disciplina/Alter";
        }
    }

    @RequestMapping(value = "/disable",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseDataModel<MDLDisciplina> disableDiscipline(@RequestParam("id") String id, Model model){
        return _disciplineAppService.processDelete(id);
    }


}
