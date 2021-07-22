package br.com.issami.hr.payroll.feignclient;

import br.com.issami.hr.payroll.entities.WorkerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Component
@FeignClient(name = "localhost:8002", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE}, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id);

}
