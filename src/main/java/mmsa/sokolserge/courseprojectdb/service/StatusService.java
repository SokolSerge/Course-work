package mmsa.sokolserge.courseprojectdb.service;

import mmsa.sokolserge.courseprojectdb.exception.StatusNotFoundException;
import mmsa.sokolserge.courseprojectdb.repo.model.Status;
import mmsa.sokolserge.courseprojectdb.repo.StatusRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StatusService {
    private final StatusRepo statusRepo;


    public StatusService (StatusRepo statusRepo){
        this.statusRepo=statusRepo;
    }

    public List<Status> getStatuses(){
        return statusRepo.findAll();
    }

    public Status saveStatus(Status newStatus) {
        return statusRepo.save(newStatus);
    }

    public Status getStatusById(Long id) {
        Optional<Status> status = statusRepo.findById(id);
        if (status.isPresent()) {
            return status.get();
        }
        throw new StatusNotFoundException();
    }

    public Status updateStatusById(Long id, Status updatedStatus) {
        Optional<Status> status = statusRepo.findById(id);
        if (status.isPresent()) {;
            Status oldStatus = status.get();
            updateStatus(oldStatus, updatedStatus);
            return statusRepo.save(oldStatus);

        }
        throw new StatusNotFoundException();
    }

    private void updateStatus(Status oldStatus, Status updatedStatus) {
        oldStatus.setStatusName(updatedStatus.getStatusName());
    }

    public String deleteStatusById(Long id) {
        if (statusRepo.findById(id).isPresent()) {
            statusRepo.deleteById(id);
            return "Status was successfully deleted";
        }
        throw new StatusNotFoundException();
    }


}
