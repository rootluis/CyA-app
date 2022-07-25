package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.ContinuityModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.continuity}",url = "${service.api.rest.domain}")
public interface ContinuityAppClient {
    @PostMapping("/continuidad/api/v2/")
    public ResponseDataModel<ContinuityModel> createContinuity(@RequestBody ContinuityModel continuityData);

    @PutMapping("/continuidad/api/v2/")
    public ResponseDataModel<ContinuityModel> alterContinuity(@RequestBody ContinuityModel continuityData);

    @DeleteMapping("/continuidad/api/v2/{id}")
    public ResponseDataModel<ContinuityModel> processDelete(@PathVariable String id);

    @GetMapping("/continuidad/api/v2/{id}")
    public ResponseDataModel<ContinuityModel> getById(@PathVariable String id);

    @GetMapping("/continuidad/api/v2/")
    public ResponseDataModel<List<ContinuityModel>> getAll();

}
