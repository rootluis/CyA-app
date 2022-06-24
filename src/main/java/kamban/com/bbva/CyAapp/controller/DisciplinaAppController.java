package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.Disciplina;
import kamban.com.bbva.CyAapp.service.DisciplinaAppService;
import kamban.com.bbva.CyAapp.service.impl.DisciplinaAppServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinaAppController.class);

    private DisciplinaAppService disciplinaAppService;

    @Autowired
    public DisciplinaAppController(DisciplinaAppService disciplinaAppService) {
        this.disciplinaAppService = disciplinaAppService;
    }

    @GetMapping("/list")
    public String getDisciplinas(Model theModel) {
        List<Disciplina> disciplinas = disciplinaAppService.getdisciplinas();
        if(disciplinas==null){
            LOGGER.info("*************  Lista nula");
            disciplinas=new ArrayList<>();
        }else {
            LOGGER.info("*************  Lista no nula");
        }

        theModel.addAttribute("disciplinas", disciplinas);
        return "disciplina/disciplinas";
    }

    @GetMapping("/showFormForAdd")
    public String addDisciplina(Model theModel) {
        Disciplina objDisciplina = new Disciplina();
        theModel.addAttribute("disciplina", objDisciplina);
        return "disciplina/disciplina-form-save";
    }
    @GetMapping("/showFormForUpdate")
    public String updateDisciplina(@RequestParam("idDisciplina") String disciplinaId, Model theModel) {
        Disciplina objDisciplina = disciplinaAppService.getDisciplinaById(disciplinaId);
        theModel.addAttribute("disciplina", objDisciplina);
        return "disciplina/disciplina-form";
    }
    @GetMapping("/delete")
    public String deleteDisciplina(@RequestParam("disciplinaId") String idDisciplina) {
        disciplinaAppService.deleteDisciplina(idDisciplina);
        return "redirect:/disciplina/list";
    }

    @PostMapping("/save")
    public String saveDisciplina(@ModelAttribute("disciplina") Disciplina objDisciplina) {
        LOGGER.info("***************          Se verifica si se modificara o si se agregara");

//        if(objDisciplina.getId()!=null && !objDisciplina.getId().isEmpty()){
//            LOGGER.info("***************          Se realizara update: "+objDisciplina.getId());
//        }else{
//            LOGGER.info("***************          Se Registrara");
//            objDisciplina.setId(null);
//        }

        disciplinaAppService.addDisciplina(objDisciplina);
        return "redirect:/disciplina/list";
    }
}
