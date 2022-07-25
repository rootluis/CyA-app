package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.DependencyStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.dependency}",url = "${service.api.rest.domain}")
public interface DependencyAppClient {
    @GetMapping("/dependencyStatus/api/v2/")
    public ResponseDataModel<List<DependencyStatusModel>> retrieveAll();

    @GetMapping("/dependencyStatus/api/v2/{id}")
    public ResponseDataModel<DependencyStatusModel> retrieveById(@PathVariable String id);

    @PostMapping("/dependencyStatus/api/v2/")
    public ResponseDataModel<DependencyStatusModel> createDependencyStatus(@RequestBody DependencyStatusModel dependencyStatusModel);

    @PutMapping("/dependencyStatus/api/v2/")
    public ResponseDataModel<DependencyStatusModel> alterDependencyStatus(@RequestBody DependencyStatusModel dependencyStatusModel);

    @DeleteMapping("/dependencyStatus/api/v2/{id}")
    public ResponseDataModel<DependencyStatusModel> processDeleteDependencyStatus(@PathVariable String id);

}
