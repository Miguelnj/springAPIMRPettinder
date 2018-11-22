package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Summary;
import es.ulpgc.gs1.gs1prototype.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SummaryService {
    private final SummaryRepository sessionSummaryRepository;
    @Autowired
    public SummaryService(SummaryRepository sessionSummaryRepository) {
        this.sessionSummaryRepository = sessionSummaryRepository;
    }

    public List<Summary> getAll(){return sessionSummaryRepository.findAll();}

    public Summary get(Long id){return sessionSummaryRepository.getOne(id);}

    public void add(Summary ss){sessionSummaryRepository.save(ss);}

}
