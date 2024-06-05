package fr.ycaby.repaircafe.core.usecases.Impl;

import fr.ycaby.repaircafe.core.exception.DeviceAbsentException;
import fr.ycaby.repaircafe.core.exception.DeviceAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.RepairAbsentException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyExistException;
import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;
import fr.ycaby.repaircafe.core.port.persistence.DeviceRepo;
import fr.ycaby.repaircafe.core.usecases.DeviceUseCase;

public class DeviceUseCaseImpl implements DeviceUseCase {

    private final DeviceRepo deviceRepo;

    public DeviceUseCaseImpl(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    /**
     * Create a device : UC03
     * @param member
     * @param device
     * @return
     * @throws DeviceAlreadyPresentException
     */
    @Override
    public Device createDevice(Member member, Device device) throws DeviceAlreadyPresentException {
        return deviceRepo.create(member, device);
    }

    /**
     * Update a device : UC08
     * @param device
     * @return
     * @throws DeviceAbsentException
     */
    @Override
    public Device updateDevice(Device device) throws DeviceAbsentException {
        return deviceRepo.update(device);
    }

    /**
     * Create a repair : UC04
     * @param device
     * @param repair
     * @return
     * @throws DeviceAbsentException
     * @throws RepairAlreadyExistException
     */
    @Override
    public Device createRepair(Device device, Repair repair) throws DeviceAbsentException, RepairAlreadyExistException {
        return deviceRepo.addRepair(device, repair);
    }

    /**
     * Update a repair : UC09
     * @param device
     * @param repair
     * @return
     * @throws DeviceAbsentException
     * @throws RepairAbsentException
     */
    @Override
    public Device updateRepair(Device device, Repair repair) throws DeviceAbsentException, RepairAbsentException {
        return deviceRepo.updateRepair(device, repair);
    }
}
