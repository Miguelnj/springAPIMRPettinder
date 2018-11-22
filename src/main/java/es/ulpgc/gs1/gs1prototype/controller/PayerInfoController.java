package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.PayerInfo;
import es.ulpgc.gs1.gs1prototype.service.PayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PayerInfoController {

    private final PayerInfoService payerInfoService;
    private static final String payerInfoPath = "/payerinfos";

    @Autowired
    public PayerInfoController(PayerInfoService payerInfoService) {
        this.payerInfoService = payerInfoService;
    }

    @GetMapping(path = payerInfoPath)
    public List<PayerInfo> getAllPayerInfos(){
        return payerInfoService.getAll();
    }

    @GetMapping(path = payerInfoPath + "/{id}")
    public PayerInfo getPayerInfo(@PathVariable Long id){
        return payerInfoService.get(id);
    }

    @PostMapping(path = payerInfoPath)
    public void addPayerInfo(@RequestBody PayerInfo payerInfo){
        payerInfoService.add(payerInfo);
    }


}
