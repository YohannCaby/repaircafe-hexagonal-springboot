package fr.ycaby.repaircafe.infrastrucure.secondary.db.repo;

import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MembershipEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MembershipPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MembershipJpaRepo extends CrudRepository<MembershipEntity, MembershipPK> {
    @Query("SELECT m FROM MembershipEntity m WHERE m.id.memberSerialNumber = :memberSerialNumber")
    List<MembershipEntity> findBySerialNumber(String memberSerialNumber);
}
