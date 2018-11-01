package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Subforum;
import es.ulpgc.gs1.gs1prototype.repository.SubforumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public Subforum get(Long id) {
        return subforumRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void delete(Long id) {
        subforumRepository.deleteById(id);
    }

    public void update(Subforum updatedSubforum, Long id) {
        Subforum subforumToBeUpdated = get(id);
        subforumToBeUpdated.setTitle(updatedSubforum.getTitle());
        subforumToBeUpdated.setDescription(updatedSubforum.getDescription());
        subforumRepository.save(subforumToBeUpdated);
    }

    public void add(Subforum subforumToBeAdded) {
        subforumToBeAdded.setNullId();
        subforumRepository.save(subforumToBeAdded);
    }
}
