package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.DeviceEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.DeviceEntityMapper;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.repo.DeviceJpaRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeviceRepo implements DeviceRepoPort {
    private final DeviceJpaRepo deviceJpaRepo;
    private final DeviceEntityMapper mapper;

    public DeviceRepo(DeviceJpaRepo deviceJpaRepo, DeviceEntityMapper mapper) {
        this.deviceJpaRepo = deviceJpaRepo;
        this.mapper = mapper;
    }

    @Override
    public Device create(Member member, Device o){
        DeviceEntity entity = mapper.toEntity(o);
        entity.setMemberSerialNumber(member.getMemberSerialNumber());
        return mapper.toDomain(deviceJpaRepo.save(entity));
    }

    @Override
    public List<Device> FindByMember(Member member) {
        return deviceJpaRepo.findByMemberSerialNumber(member.getMemberSerialNumber()).stream().map(mapper::toDomain).toList();
    }

    @Override
    public Device update(Device o){
        return mapper.toDomain(deviceJpaRepo.save(mapper.toEntity(o)));
    }
}
