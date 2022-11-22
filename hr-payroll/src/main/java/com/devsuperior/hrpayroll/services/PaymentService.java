package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

//    @Value("${hr-worker.host}")
//    private String workerHost;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WorkerFeingClient workerFeingClient;

//    public Payment getPayment(long workerId, Integer days) {
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("id", String.valueOf(workerId));
//
//        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
//        return new Payment(worker.getName(), worker.getDailyIncome(), days);
//    }

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeingClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
