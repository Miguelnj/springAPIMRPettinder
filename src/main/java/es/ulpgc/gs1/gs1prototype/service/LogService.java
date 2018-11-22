package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Log;
import es.ulpgc.gs1.gs1prototype.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;
    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> getAll(){return logRepository.findAll();}

    public Log get(Long id){return logRepository.getOne(id);}

    public void add(Log ss){logRepository.save(ss);}

}
