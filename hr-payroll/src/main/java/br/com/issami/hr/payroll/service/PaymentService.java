package br.com.issami.hr.payroll.service;

import br.com.issami.hr.payroll.entities.Payment;
import br.com.issami.hr.payroll.entities.WorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;
import static org.springframework.http.HttpMethod.GET;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", valueOf(workerId));

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity httpEntity = new HttpEntity(headers);
        final ResponseEntity<WorkerDTO> responseEntity = restTemplate.exchange("http://hr-worker/workers/{id}", GET, httpEntity, WorkerDTO.class, params);
        final WorkerDTO workerDTO = responseEntity.getBody();

        return new Payment(workerDTO.getName(), workerDTO.getDailyIncome(), days);
    }
}
