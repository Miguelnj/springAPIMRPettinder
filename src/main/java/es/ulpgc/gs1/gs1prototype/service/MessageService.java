package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.Message;
import es.ulpgc.gs1.gs1prototype.model.DTO.MessageDTO;
import es.ulpgc.gs1.gs1prototype.model.Thread;
import es.ulpgc.gs1.gs1prototype.repository.MessageRepository;
import es.ulpgc.gs1.gs1prototype.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ThreadService threadService;

    @Autowired
    public MessageService(MessageRepository messageRepository,ThreadService threadService) {
        this.messageRepository = messageRepository;
        this.threadService = threadService;
    }

    public List<Message> getAll(){
        return messageRepository.findAll();
    }

    public Message get(Long id) {
        return messageRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void add(MessageDTO message) {
        Message messageToAdd = new Message(message.getContent(), getLoggedUser().getUsername());
        messageToAdd = messageRepository.save(messageToAdd);

        Thread parentThread = threadService.get(message.getParentThreadId());
        parentThread.getMessages().add(messageToAdd);
        threadService.update(message.getParentThreadId(),parentThread);
    }

    public void update(Long id, Message message) {
        Message messageToBeUpdated = get(id);

        messageToBeUpdated.setContent(message.getContent());
        messageToBeUpdated.setLastEditDate(LocalDateTime.now());
        messageToBeUpdated.increaseModifiedCount();

        messageRepository.save(messageToBeUpdated);
    }

    private MyUserPrincipal getLoggedUser() {
        return (MyUserPrincipal) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
