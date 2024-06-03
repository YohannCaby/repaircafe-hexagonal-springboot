package fr.ycaby.repaircafe.core.port.persistence;

import fr.ycaby.repaircafe.core.exception.RepairAbsentException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyPresentException;
import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;

public interface DeviceRepo {
    Device create(Member member, Device device);
    Device update(Member member, Device device);
    Device addRepair(Device device, Repair repair) throws RepairAlreadyPresentException;
    Device updateRepair(Device device, Repair repair) throws RepairAbsentException;
}
