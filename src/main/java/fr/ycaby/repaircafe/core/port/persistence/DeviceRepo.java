package fr.ycaby.repaircafe.core.port.persistence;

import fr.ycaby.repaircafe.core.exception.DeviceAbsentException;
import fr.ycaby.repaircafe.core.exception.DeviceAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.RepairAbsentException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyPresentException;
import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;

public interface DeviceRepo {
    Device create(Member member, Device device) throws DeviceAlreadyPresentException;
    Device update(Device device) throws DeviceAbsentException;
    Device addRepair(Device device, Repair repair) throws RepairAlreadyPresentException, DeviceAbsentException;
    Device updateRepair(Device device, Repair repair) throws RepairAbsentException, DeviceAbsentException;
}