package fr.ycaby.repaircafe.core.usecases.Impl;

import fr.ycaby.repaircafe.core.port.persistence.DeviceRepo;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.RepairRepoPort;

public class DeviceUseCaseImpl implements fr.ycaby.repaircafe.core.usecases.DeviceUseCase {

    private final DeviceRepo deviceRepo;


    public DeviceUseCaseImpl(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }
}
