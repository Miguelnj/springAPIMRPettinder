package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.SessionSummary;
import es.ulpgc.gs1.gs1prototype.service.SessionSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SessionSummaryController {

    private final SessionSummaryService sessionSummaryService;
    private static final String sessionSummaryPath = "/sessionsummaries";

    @Autowired
    public SessionSummaryController(SessionSummaryService sessionSummaryService) {
        this.sessionSummaryService = sessionSummaryService;
    }

    @GetMapping(path = sessionSummaryPath)
    public List<SessionSummary> getAllSessionSummaries(){
        return sessionSummaryService.getAll();
    }

    @GetMapping(path = sessionSummaryPath + "/{id}")
    public SessionSummary getSessionSummary(@PathVariable Long id){
        return sessionSummaryService.get(id);
    }

    @PostMapping(path = sessionSummaryPath)
    public void addSessionSummary(@RequestBody SessionSummary sessionSummary){
        sessionSummaryService.add(sessionSummary);
    }


}