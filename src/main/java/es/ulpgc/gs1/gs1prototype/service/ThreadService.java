package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.DTO.NoMessageThreadDTO;
import es.ulpgc.gs1.gs1prototype.model.Message;
import es.ulpgc.gs1.gs1prototype.model.Subforum;
import es.ulpgc.gs1.gs1prototype.model.Thread;
import es.ulpgc.gs1.gs1prototype.model.DTO.ThreadDTO;
import es.ulpgc.gs1.gs1prototype.repository.ThreadRepository;
import es.ulpgc.gs1.gs1prototype.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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
        Thread thread = new Thread(threadDTO.getDescription(),threadDTO.getTitle(),threadDTO.getMessages(),getLoggedUser().getUsername());
        thread = threadRepository.save(thread);

        Subforum subforum = subforumService.get(threadDTO.getParentSubforumId());
        subforum.getThreads().add(thread);
        subforumService.update(subforum,subforum.getId());
    }

    public void update(Long id, Thread thread) {
        Thread threadToBeUpdated = get(id);

        threadToBeUpdated.setDescription(thread.getDescription());
        threadToBeUpdated.setOpen(thread.getOpen());
        threadToBeUpdated.setTitle(thread.getTitle());

        threadRepository.save(thread);
    }

    private MyUserPrincipal getLoggedUser() {
        return (MyUserPrincipal) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public Set<Message> getMessagesGivenId(Long id) {
        return get(id).getMessages();
    }

    public ArrayList<NoMessageThreadDTO> getAllThreadsNotSendingMessages() {
        return getNoMessageThreadDTOS(getAllThreads());
    }

    public ArrayList<NoMessageThreadDTO> getNoMessageThreadDTOS(List<Thread> threads) {
        ArrayList<NoMessageThreadDTO> noMessageThreadDTOS = new ArrayList<>();
        for (Thread thread : threads) {
            noMessageThreadDTOS.add(new NoMessageThreadDTO(thread.getId(),thread.getTitle(),thread.getDescription(),
                    thread.getOpen(),thread.getCreationDate(),thread.getCreatedBy()));
        }
        return noMessageThreadDTOS;
    }
}
