package fr.ycaby.repaircafe.core.port.persistence.port;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;

public interface DeviceRepoPort extends IGenericFromPort<Member,Device> {
    Boolean isDeviceExist(Device device);
}
