package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.SprintModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.sprint}",url = "${service.api.rest.domain}")
public interface SprintAppClient {
    @GetMapping("/sprint/api/v2/")
    public ResponseDataModel<List<SprintModel>> getAll();

    @GetMapping("/sprint/api/v2/{id}")
    public ResponseDataModel<SprintModel> getById(@PathVariable String id);

    @PostMapping("/sprint/api/v2/")
    public ResponseDataModel<SprintModel> createSprint(@RequestBody SprintModel sprintData);

    @PutMapping("/sprint/api/v2/")
    public ResponseDataModel<SprintModel> alterSprint(@RequestBody SprintModel sprintData);

    @DeleteMapping("/sprint/api/v2/{id}")
    public ResponseDataModel<SprintModel> processDeleteSprint(@PathVariable String id);

}
