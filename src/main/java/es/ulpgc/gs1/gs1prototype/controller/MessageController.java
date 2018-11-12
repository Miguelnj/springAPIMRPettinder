package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.Message;
import es.ulpgc.gs1.gs1prototype.model.MessageDTO;
import es.ulpgc.gs1.gs1prototype.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;
    public static final String messagePath = "/messages";

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8100"},
            maxAge = 4800, allowCredentials = "false")
    @GetMapping(path = messagePath)
    public List<Message> getAllMessages(){
        return messageService.getAll();
    }

    @GetMapping(path = messagePath + "/{id}")
    public Message getMessage(@PathVariable Long id){
        return messageService.get(id);
    }

    @PostMapping(path = messagePath)
    public void addMessage(@RequestBody MessageDTO message){
        messageService.add(message);
    }

    @PutMapping(path = messagePath + "/{id}")
    public void updateMessage(@PathVariable Long id, @RequestBody Message message){
        messageService.update(id, message);
    }

}
