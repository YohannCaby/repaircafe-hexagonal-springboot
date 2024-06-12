package fr.ycaby.repaircafe.infrastrucure.secondary.db.repo;

import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MemberEntitiy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberJpaRepo extends CrudRepository<MemberEntitiy,String> {

    List<MemberEntitiy> findByMemberSerialNumber(String serialNumber);

    List<MemberEntitiy> findByNameContainingOrSurnameContaining(String name, String surname);

    boolean existsByMemberSerialNumber(String serialNumber);
}
