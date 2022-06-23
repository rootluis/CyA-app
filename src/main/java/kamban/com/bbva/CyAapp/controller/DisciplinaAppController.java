package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.Disciplina;
import kamban.com.bbva.CyAapp.service.DisciplinaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaAppController {

    private DisciplinaAppService disciplinaAppService;

    @Autowired
    public DisciplinaAppController(DisciplinaAppService disciplinaAppService) {
        this.disciplinaAppService = disciplinaAppService;
    }

    @GetMapping("/list")
    public String getDisciplinas(Model theModel) {
        List<Disciplina> disciplinas = disciplinaAppService.getdisciplinas();
        theModel.addAttribute("disciplinas", disciplinas);
        return "disciplina/disciplinas";
    }

    @GetMapping("/showFormForAdd")
    public String addDisciplina(Model theModel) {
        List<Disciplina> disciplinas = disciplinaAppService.getdisciplinas();
        int[] valIds = new int[disciplinas.size()];
        int rowIdx = 0;
        for (Disciplina objDisciplina : disciplinas) {
            valIds[rowIdx] = Math.toIntExact(objDisciplina.getId());
            rowIdx++;
        }

        int maxId = valIds[0];
        for (int val : valIds) {
            if (val > maxId) {
                maxId = val;
            }
        }

        Disciplina disciplina = new Disciplina();
        disciplina.setId((long) maxId + 1);
        theModel.addAttribute("disciplina", disciplina);
        return "disciplina/disciplina-form";
    }

    @GetMapping("/showFormForUpdate")
    public String updateDisciplina(@RequestParam("disciplinaId") Long disciplina, Model theModel) {
        Disciplina objDisciplina = disciplinaAppService.getDisciplina(disciplina);
        theModel.addAttribute("disciplina", objDisciplina);
        return "disciplina/disciplina-form";
    }

    @PostMapping("/save")
    public String saveDisciplina(@ModelAttribute("disciplina") Disciplina objDisciplina) {
        disciplinaAppService.addDisciplina(objDisciplina);
        return "redirect:/disciplina/list";
    }

    @GetMapping("/delete")
    public String deleteDisciplina(@RequestParam("disciplinaId") Long idDisciplina){
        disciplinaAppService.deleteDisciplina(idDisciplina);
        return "redirect:/disciplina/list";
    }

}
