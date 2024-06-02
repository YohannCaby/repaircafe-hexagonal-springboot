package fr.ycaby.repaircafe.core.usecases.Impl;

import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.RepairRepoPort;

public class DeviceUseCaseImpl implements fr.ycaby.repaircafe.core.usecases.DeviceUseCase {

    private final DeviceRepoPort deviceRepo;
    private final RepairRepoPort repairRepo;

    public DeviceUseCaseImpl(DeviceRepoPort deviceRepo, RepairRepoPort repairRepo) {
        this.deviceRepo = deviceRepo;
        this.repairRepo = repairRepo;
    }


}
