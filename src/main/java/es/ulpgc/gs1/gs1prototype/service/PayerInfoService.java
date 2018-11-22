package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.PayerInfo;
import es.ulpgc.gs1.gs1prototype.repository.PayerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayerInfoService {
    private final PayerInfoRepository payerInfoRepository;
    @Autowired
    public PayerInfoService(PayerInfoRepository payerInfoRepository) {
        this.payerInfoRepository = payerInfoRepository;
    }

    public List<PayerInfo> getAll(){return payerInfoRepository.findAll();}

    public PayerInfo get(Long id){return payerInfoRepository.getOne(id);}

    public void add(PayerInfo ss){payerInfoRepository.save(ss);}


}
