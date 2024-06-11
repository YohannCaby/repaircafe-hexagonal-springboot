package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Repair;
import fr.ycaby.repaircafe.core.port.persistence.port.RepairRepoPort;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RepairEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RepairPK;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.RepairEntityMapper;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.repo.RepairJpaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepaireRepo implements RepairRepoPort {

    private final RepairJpaRepo repairJpaRepo;
    private final RepairEntityMapper mapper;

    public RepaireRepo(RepairJpaRepo repairJpaRepo, RepairEntityMapper mapper) {
        this.repairJpaRepo = repairJpaRepo;
        this.mapper = mapper;
    }

    @Override
    public List<Repair> getFrom(Device device) {
        return repairJpaRepo.findByDeviceSerialNumber(device.getDeviceSerialNumber()).stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean isFromExist(Device device, Repair o) {
        return repairJpaRepo.existsById(RepairPK.builder()
                .deviceSerialNumber(device.getDeviceSerialNumber())
                .date(o.getDate())
                .build());
    }

    @Override
    public Repair updateFrom(Device device, Repair o) {
        return saveOrUptade(device, o);
    }

    @Override
    public Repair createFrom(Device device, Repair o) {
        return saveOrUptade(device, o);
    }

    @Override
    public Repair removeFrom(Device device, Repair o) {
        RepairEntity entity = mapper.toEntity(o);
        entity.getId().setDeviceSerialNumber(device.getDeviceSerialNumber());
        repairJpaRepo.delete(entity);
        return o;
    }

    private Repair saveOrUptade(Device device, Repair o) {
        RepairEntity entity = mapper.toEntity(o);
        entity.getId().setDeviceSerialNumber(device.getDeviceSerialNumber());
        return mapper.toDomain(repairJpaRepo.save(entity));
    }

}
