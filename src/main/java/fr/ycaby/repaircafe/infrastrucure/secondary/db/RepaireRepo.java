package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Repair;
import fr.ycaby.repaircafe.core.port.persistence.port.RepairRepoPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepaireRepo implements RepairRepoPort {

    @Override
    public List<Repair> getFrom(Device device) {
        return List.of();
    }

    @Override
    public boolean isFromExist(Device device, Repair o) {
        return false;
    }

    @Override
    public Repair updateFrom(Device device, Repair o) {
        return null;
    }

    @Override
    public Repair createFrom(Device device, Repair o) {
        return null;
    }

    @Override
    public Repair removeFrom(Device device, Repair o) {
        return null;
    }
}
