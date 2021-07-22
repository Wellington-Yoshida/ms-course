package br.com.issami.hr.payroll.controller;

import br.com.issami.hr.payroll.entities.Payment;
import br.com.issami.hr.payroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{workerId}/days/{days}", consumes = {MediaType.APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
                                                   produces = {MediaType.APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable int days) {
        return new ResponseEntity<>(paymentService.getPayment(workerId, days), OK);
    }

}
