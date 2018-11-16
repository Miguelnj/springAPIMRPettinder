package es.ulpgc.gs1.gs1prototype.service;

import es.ulpgc.gs1.gs1prototype.model.DTO.NoMessageThreadDTO;
import es.ulpgc.gs1.gs1prototype.model.DTO.NoThreadSubforumDTO;
import es.ulpgc.gs1.gs1prototype.model.Subforum;
import es.ulpgc.gs1.gs1prototype.model.Thread;
import es.ulpgc.gs1.gs1prototype.repository.SubforumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class SubforumService {

    private final SubforumRepository subforumRepository;

    @Autowired
    public SubforumService(SubforumRepository subforumRepository){
        this.subforumRepository = subforumRepository;
    }

    public List<Subforum> getAllSubforums() {
        return subforumRepository.findAll();
    }

    public Subforum get(Long id) {
        return subforumRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void delete(Long id) {
        subforumRepository.deleteById(id);
    }

    public void update(Subforum updatedSubforum, Long id) {
        Subforum subforumToBeUpdated = get(id);

        subforumToBeUpdated.setTitle(updatedSubforum.getTitle());
        subforumToBeUpdated.setDescription(updatedSubforum.getDescription());
        subforumToBeUpdated.setThreads(updatedSubforum.getThreads());

        subforumRepository.save(subforumToBeUpdated);
    }

    public void add(Subforum subforumToBeAdded) {
        subforumToBeAdded.setNullId();
        subforumRepository.save(subforumToBeAdded);
    }

    public ArrayList<NoMessageThreadDTO> getThreadsGivenId(Long id) {
        return threadsToNoMessageThread(get(id).getThreads());
    }

    private ArrayList<NoMessageThreadDTO> threadsToNoMessageThread(Set<Thread> threadsOfSubforum) {
        ArrayList<NoMessageThreadDTO> threadsWithoutMessagesField = new ArrayList<>();
        for (Thread thread : threadsOfSubforum) {
            threadsWithoutMessagesField.add(new NoMessageThreadDTO(thread.getId(),
                    thread.getTitle(),thread.getDescription(),thread.getOpen(),
                    thread.getCreationDate(),thread.getCreatedBy()));
        }
        return threadsWithoutMessagesField;
    }

    public ArrayList<NoThreadSubforumDTO> getAllSubforumsNotSendingTheirThreads() {
        return getNoThreadSubforumDTOS(getAllSubforums());
    }

    private ArrayList<NoThreadSubforumDTO> getNoThreadSubforumDTOS(List<Subforum> listOfSubforums) {
        ArrayList<NoThreadSubforumDTO> noThreadSubforumDTOS = new ArrayList<>();

        for (Subforum subforum : listOfSubforums) {
            noThreadSubforumDTOS.add(new NoThreadSubforumDTO(subforum.getId(),
                    subforum.getTitle(),
                    subforum.getDescription()));
        }
        return noThreadSubforumDTOS;
    }
}
