package fr.ycaby.repaircafe.core.usecases;

import fr.ycaby.repaircafe.core.exception.DeviceAbsentException;
import fr.ycaby.repaircafe.core.exception.DeviceAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.RepairAbsentException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyExistException;
import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;

public interface DeviceUseCase {
    Device createDevice(Member member, Device device) throws DeviceAlreadyPresentException;
    Device updateDevice(Member member, Device device) throws DeviceAbsentException;
    Device createRepair(Device device, Repair repair) throws DeviceAbsentException, RepairAlreadyExistException;
    Device updateRepair(Device device, Repair repair) throws DeviceAbsentException, RepairAbsentException;
}
