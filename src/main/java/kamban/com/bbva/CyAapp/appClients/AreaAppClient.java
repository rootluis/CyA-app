package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.AreaModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.area}",url = "${service.api.rest.domain}")
public interface AreaAppClient {

    @PostMapping("/area/api/v2/")
    public ResponseDataModel<AreaModel> createArea(@RequestBody AreaModel areaData);

    @PutMapping("/area/api/v2/")
    public ResponseDataModel<AreaModel> updateArea(@RequestBody AreaModel areaData);

    @GetMapping("/area/api/v2/")
    public ResponseDataModel<List<AreaModel>> getAll();

    @GetMapping("/area/api/v2/{idArea}")
    public ResponseDataModel<AreaModel> getById(@PathVariable String idArea);

    @DeleteMapping("/area/api/v2/{id}")
    public ResponseDataModel<AreaModel> processDisableArea(@PathVariable String id);

}
