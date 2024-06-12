package fr.ycaby.repaircafe.infrastrucure.secondary.db.repo;

import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RepairEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RepairPK;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepairJpaRepo extends CrudRepository<RepairEntity, RepairPK> {
    @Query("SELECT m FROM RepairEntity m WHERE m.id.deviceSerialNumber = :deviceSerialNumber")
    List<RepairEntity> findByDeviceSerialNumber(String deviceSerialNumber);
}
