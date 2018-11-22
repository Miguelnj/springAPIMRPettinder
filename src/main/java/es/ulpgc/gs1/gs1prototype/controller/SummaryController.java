package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.Summary;
import es.ulpgc.gs1.gs1prototype.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SummaryController {

    private final SummaryService summaryService;
    private static final String summaryPath = "/summary";

    @Autowired
    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping(path = summaryPath)
    public List<Summary> getAllSummary(){
        return summaryService.getAll();
    }

    @GetMapping(path = summaryPath + "/{id}")
    public Summary getSummary(@PathVariable Long id){
        return summaryService.get(id);
    }

    @PostMapping(path = summaryPath)
    public void addSummary(@RequestBody Summary summary){
        summaryService.add(summary);
    }


}
