package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.Log;
import es.ulpgc.gs1.gs1prototype.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LogController {

    private final LogService logService;
    private static final String logPath = "/logs";

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping(path = logPath)
    public List<Log> getAllLogs(){
        return logService.getAll();
    }

    @GetMapping(path = logPath + "/{id}")
    public Log getLog(@PathVariable Long id){
        return logService.get(id);
    }

    @PostMapping(path = logPath)
    public void addLog(@RequestBody Log log){
        logService.add(log);
    }



}
