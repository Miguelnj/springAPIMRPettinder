package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Subforum;
import es.ulpgc.gs1.gs1prototype.repository.SubforumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubforumService {

    private final SubforumRepository subforumRepository;

    @Autowired
    public SubforumService(SubforumRepository subforumRepository){
        this.subforumRepository = subforumRepository;
    }

    public List<Subforum> getAllSubforums() {
        return subforumRepository.findAll();
    }
}
