package mmsa.sokolserge.courseprojectdb.repo;

import mmsa.sokolserge.courseprojectdb.repo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
