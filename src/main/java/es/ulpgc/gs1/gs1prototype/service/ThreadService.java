package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Thread;
import es.ulpgc.gs1.gs1prototype.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ThreadService {

    private final ThreadRepository threadRepository;

    @Autowired
    public ThreadService(ThreadRepository threadRepository){
        this.threadRepository = threadRepository;
    }

    public List<Thread> getAllThreads() {
        return threadRepository.findAll();
    }

    public Thread get(Long id) {
        return threadRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void add(Thread thread) {
        threadRepository.save(thread);
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
