package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.DDStageModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.stage}",url = "${service.api.rest.domain}")
public interface DDStageAppClient {

    @GetMapping("/stage/api/v2/")
    public ResponseDataModel<List<DDStageModel>> retrieveAll();

    @GetMapping("/stage/api/v2/{id}")
    public ResponseDataModel<DDStageModel> retrieveById(@PathVariable String id);

    @PostMapping("/stage/api/v2/")
    public ResponseDataModel<DDStageModel> createStage(@RequestBody DDStageModel ddStageData);

    @PutMapping("/stage/api/v2/")
    public ResponseDataModel<DDStageModel> alterStage(@RequestBody DDStageModel ddStageData);

    @DeleteMapping("/stage/api/v2/{id}")
    public ResponseDataModel<DDStageModel> disableStage(@PathVariable String id);

}
