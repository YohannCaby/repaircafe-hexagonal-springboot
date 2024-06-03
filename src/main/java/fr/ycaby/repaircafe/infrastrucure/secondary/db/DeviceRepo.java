package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeviceRepo implements DeviceRepoPort {

    @Override
    public List<Device> getFrom(Member member) {
        return List.of();
    }

    @Override
    public boolean isFromExist(Member member, Device o) {
        return false;
    }

    @Override
    public Device updateFrom(Member member, Device o) {
        return null;
    }

    @Override
    public Device createFrom(Member member, Device o) {
        return null;
    }

    @Override
    public Device removeFrom(Member member, Device o) {
        return null;
    }

    @Override
    public Boolean isDeviceExist(Device device) {
        return true;
    }

}
