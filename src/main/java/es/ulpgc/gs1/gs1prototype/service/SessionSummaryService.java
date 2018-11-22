package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.SessionSummary;
import es.ulpgc.gs1.gs1prototype.repository.SessionSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SessionSummaryService {
    private final SessionSummaryRepository sessionSummaryRepository;
    @Autowired
    public SessionSummaryService(SessionSummaryRepository sessionSummaryRepository) {
        this.sessionSummaryRepository = sessionSummaryRepository;
    }

    public List<SessionSummary> getAll(){return sessionSummaryRepository.findAll();}

    public SessionSummary get(Long id){return sessionSummaryRepository.getOne(id);}

    public void add(SessionSummary ss){sessionSummaryRepository.save(ss);}

}
