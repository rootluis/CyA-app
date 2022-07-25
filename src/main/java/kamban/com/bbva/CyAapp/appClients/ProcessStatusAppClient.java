package kamban.com.bbva.CyAapp.appClients;

import kamban.com.bbva.CyAapp.model.ProcessStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${service.api.rest.name.process}",url = "${service.api.rest.domain}")
public interface ProcessStatusAppClient {
    @GetMapping("/processStatus/api/v2/")
    public ResponseDataModel<List<ProcessStatusModel>> retrieveAll();

    @GetMapping("/processStatus/api/v2/{id}")
    public ResponseDataModel<ProcessStatusModel> retrieveById(@PathVariable String id);

    @PostMapping("/processStatus/api/v2/")
    public ResponseDataModel<ProcessStatusModel> createProcessStatus(@RequestBody ProcessStatusModel processStatusModel);

    @PutMapping("/processStatus/api/v2/")
    public ResponseDataModel<ProcessStatusModel> alter(@RequestBody ProcessStatusModel processStatusModel);

    @DeleteMapping("/processStatus/api/v2/{id}")
    public ResponseDataModel<ProcessStatusModel> processDelete(@PathVariable String id);

}
