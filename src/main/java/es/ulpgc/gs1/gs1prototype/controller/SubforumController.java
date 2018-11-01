package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.Subforum;
import es.ulpgc.gs1.gs1prototype.service.SubforumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(subforumPath + "/{id}")
    public Subforum getSubforum(@PathVariable Long id){
        return subforumService.get(id);
    }

    @DeleteMapping(subforumPath + "/{id}")
    public void deleteSubforum(@PathVariable Long id){
        subforumService.delete(id);
    }

    @PostMapping(subforumPath)
    public void postSubforum(@RequestBody Subforum subforumToBeAdded){
        subforumService.add(subforumToBeAdded);
    }

    @PutMapping(subforumPath + "/{id}")
    public void updateSubforum(@RequestBody Subforum updatedSubforum, @PathVariable Long id){
        subforumService.update(updatedSubforum, id);
    }


}
