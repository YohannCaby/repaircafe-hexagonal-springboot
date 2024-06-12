package fr.ycaby.repaircafe.infrastrucure.secondary.db.repo;

import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RoleEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RolePK;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleJpaRepo extends CrudRepository<RoleEntity, RolePK>{
    @Query("SELECT m FROM RoleEntity m WHERE m.id.memberSerialNumber = :memberSerialNumber")
    List<RoleEntity> findBySerialNumber(String memberSerialNumber);
}
