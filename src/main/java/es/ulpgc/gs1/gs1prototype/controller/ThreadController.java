package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.Thread;
import es.ulpgc.gs1.gs1prototype.model.ThreadDTO;
import es.ulpgc.gs1.gs1prototype.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThreadController {

    private final ThreadService threadService;
    public static final String threadPath = "/threads";

    @Autowired
    public ThreadController(ThreadService threadService){
        this.threadService = threadService;
    }
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8100"},
            maxAge = 4800, allowCredentials = "false")
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

}
