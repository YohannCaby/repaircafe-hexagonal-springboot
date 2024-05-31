package fr.ycaby.repaircafe.infrastrucure.secondary.db.repo;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MemberEntitiy;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.List;

public interface MemberJpaRepo extends CrudRepository<MemberEntitiy,String> {

    List<MemberEntitiy> findBySerialNumber(String serialNumber);

    List<MemberEntitiy> findByNameContainingOrSurnameContaining(String name, String surname);

    boolean existsBySerialNumber(String serialNumber);
}
