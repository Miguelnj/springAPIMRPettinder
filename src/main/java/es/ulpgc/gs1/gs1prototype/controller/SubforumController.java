package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.Subforum;
import es.ulpgc.gs1.gs1prototype.service.SubforumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubforumController {

    public static final String subforumPath = "/subforums";
    private final SubforumService subforumService;

    @Autowired
    public SubforumController(SubforumService subforumService){
        this.subforumService = subforumService;
    }

    @GetMapping(subforumPath)
    public List<Subforum> getAllSubforums(){
        return subforumService.getAllSubforums();
    }

}
