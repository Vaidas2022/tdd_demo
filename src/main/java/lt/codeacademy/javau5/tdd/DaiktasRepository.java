package lt.codeacademy.javau5.tdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaiktasRepository extends JpaRepository<Daiktas, Long> {

}
