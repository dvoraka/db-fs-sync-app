package dvoraka.dbfssyncapp.repository;

import dvoraka.dbfssyncapp.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
