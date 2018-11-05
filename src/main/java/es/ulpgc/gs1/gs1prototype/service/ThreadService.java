package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Subforum;
import es.ulpgc.gs1.gs1prototype.model.Thread;
import es.ulpgc.gs1.gs1prototype.model.ThreadDTO;
import es.ulpgc.gs1.gs1prototype.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ThreadService {

    private final ThreadRepository threadRepository;
    private final SubforumService subforumService;

    @Autowired
    public ThreadService(ThreadRepository threadRepository,SubforumService subforumService){
        this.threadRepository = threadRepository;
        this.subforumService = subforumService;
    }

    public List<Thread> getAllThreads() {
        return threadRepository.findAll();
    }

    public Thread get(Long id) {
        return threadRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void add(ThreadDTO threadDTO) {
        Thread thread = new Thread(threadDTO.getDescription(),threadDTO.getTitle());

        thread = threadRepository.save(thread);

        Subforum subforum = subforumService.get(threadDTO.getParentSubforumId());
        subforum.getThreads().add(thread);
        subforumService.update(subforum,subforum.getId());
    }

    public void delete(Long id) {
        threadRepository.deleteById(id);
    }

    public void update(Long id, Thread thread) {
        Thread threadToBeUpdated = get(id);

        threadToBeUpdated.setDescription(thread.getDescription());
        threadToBeUpdated.setOpen(thread.getOpen());
        threadToBeUpdated.setTitle(thread.getTitle());

        threadRepository.save(thread);
    }
}
