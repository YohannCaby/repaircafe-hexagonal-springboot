package fr.ycaby.repaircafe.infrastrucure.secondary.db.repo;

import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.DeviceEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DeviceJpaRepo extends CrudRepository<DeviceEntity, String> {
    List<DeviceEntity> findByMemberSerialNumberAndDeviceSerialNumber(String memberSerialNumber, String deviceSerialNumber);
    List<DeviceEntity> findByMemberSerialNumber(String memberSerialNumber);
}
