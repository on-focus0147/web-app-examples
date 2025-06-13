package on.focus0147.repositories;

import on.focus0147.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {

    @Query("select s from ClientEntity s where s.firstName=:fn")
    Iterable<ClientEntity> findByFirstName(@Param("fn") String firstName);
}
