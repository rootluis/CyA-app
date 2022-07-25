package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.MDLDisciplina;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.discipline}",url = "${service.api.rest.domain}")
public interface DisciplinaAppClient {
    @PostMapping(value = "/disciplina/api/v2/")
    public ResponseDataModel<MDLDisciplina> createDisciplina(@RequestBody MDLDisciplina disciplina);

    @PutMapping(value = "/disciplina/api/v2/")
    public ResponseDataModel<MDLDisciplina> updateDisciplina(@RequestBody MDLDisciplina disciplina);

    @DeleteMapping("/disciplina/api/v2/{idDiscipline}")
    public ResponseDataModel<MDLDisciplina> processDeleteDiscipline(@PathVariable String idDiscipline);


    @GetMapping(value = "/disciplina/api/v2/")
    public ResponseDataModel<List<MDLDisciplina>> getAll();

    @GetMapping(value = "/disciplina/api/v2/{idDisciplina}")
    public ResponseDataModel<MDLDisciplina> getById(@PathVariable String idDisciplina);
}
