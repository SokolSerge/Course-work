package mmsa.sokolserge.courseprojectdb.repo;

import mmsa.sokolserge.courseprojectdb.repo.model.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductSizeRepo extends JpaRepository<ProductSize, Long>{
}
