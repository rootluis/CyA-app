package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.TechnologyModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.technology}",url = "${service.api.rest.domain}")
public interface TechnologyAppClient {
    @GetMapping("/technology/api/v1/")
    public ResponseDataModel<List<TechnologyModel>> getTechnologies();

    @GetMapping("/technology/api/v1/{id}")
    public ResponseDataModel<TechnologyModel> getTechnologyById(@PathVariable String id);

    @PostMapping("/technology/api/v1/")
    public ResponseDataModel<TechnologyModel> createTecnology(@RequestBody TechnologyModel objTechnology);

    @PutMapping("/technology/api/v1/")
    public ResponseDataModel<TechnologyModel> alterTecnologi(@RequestBody TechnologyModel objTechnology);

    @DeleteMapping("/technology/api/v1/{id}")
    public ResponseDataModel<TechnologyModel> processDeleteTecnologi(@PathVariable String id);

}
