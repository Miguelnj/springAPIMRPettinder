package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.DTO.NoMessageThreadDTO;
import es.ulpgc.gs1.gs1prototype.model.Message;
import es.ulpgc.gs1.gs1prototype.model.Thread;
import es.ulpgc.gs1.gs1prototype.model.DTO.ThreadDTO;
import es.ulpgc.gs1.gs1prototype.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "http://3d2208cc.ngrok.io"},
        maxAge = 4800, allowCredentials = "true")
public class ThreadController {

    private final ThreadService threadService;
    public static final String threadPath = "/threads";

    @Autowired
    public ThreadController(ThreadService threadService){
        this.threadService = threadService;
    }

    @GetMapping(threadPath)
    public List<Thread> getAllThreads(){
        return threadService.getAllThreads();
    }


    @GetMapping(threadPath + "/{id}")
    public Thread getThread(@PathVariable Long id){
        return threadService.get(id);
    }

    @PostMapping(threadPath)
    public void addThread(@RequestBody ThreadDTO threadDTO){
        threadService.add(threadDTO);
    }

    @PutMapping(threadPath + "/{id}")
    public void updateThread(@PathVariable Long id, @RequestBody Thread thread){
        threadService.update(id,thread);
    }

    @GetMapping(threadPath + "/{id}/messages")
    public Set<Message> getAllMessagesGivenId(@PathVariable Long id){
        return threadService.getMessagesGivenId(id);
    }

    @GetMapping(threadPath + "/noMessages")
    public ArrayList<NoMessageThreadDTO> getAllThreadsNotSendingMessages(){
        return threadService.getAllThreadsNotSendingMessages();
    }

}
