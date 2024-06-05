package fr.ycaby.repaircafe.core.port.persistence.port;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import java.util.List;

public interface DeviceRepoPort{

    Device update(Device o);

    Device create(Member member, Device o);

    List<Device> FindByMember(Member member);
}
