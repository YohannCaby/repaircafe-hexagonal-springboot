package fr.ycaby.repaircafe.core.port.persistence.impl;

import fr.ycaby.repaircafe.core.exception.DeviceAbsentException;
import fr.ycaby.repaircafe.core.exception.DeviceAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.RepairAbsentException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyPresentException;
import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;
import fr.ycaby.repaircafe.core.port.persistence.DeviceRepo;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.RepairRepoPort;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepoImpl implements DeviceRepo {

    private final DeviceRepoPort deviceRepo;

    private final RepairRepoPort repairRepo;

    private final static String DEVICE_NAMED= "Device named : ";
    private final static String NOT_EXIST = " not exist";

    public DeviceRepoImpl(DeviceRepoPort deviceRepo, RepairRepoPort repairRepo) {
        this.deviceRepo = deviceRepo;
        this.repairRepo = repairRepo;
    }

    @Override
    public Device create(Member member, Device device) {
        if(!isDeviceExist(device))
            throw new DeviceAlreadyPresentException(DEVICE_NAMED+ device.getName() + " already exist");
        device.genSerialNumber();
        Device response = deviceRepo.create(member,device);
        List<Repair> repairs = new ArrayList<>();
        if(!device.getRepairList().isEmpty()){
            for(Repair repair : device.getRepairList()){
                repairs.add(repairRepo.createFrom(device,repair));
            }
        }
        response.setRepairList(repairs);
        return response;
    }

    @Override
    public Device update(Device device) {
        if(!isDeviceExist(device))
            throw new DeviceAbsentException(DEVICE_NAMED+ device.getName() + NOT_EXIST);

        Device response = deviceRepo.update(device);
        List<Repair> repairs = new ArrayList<>();
        if(!device.getRepairList().isEmpty()){
            for(Repair repair : device.getRepairList()){
                repairs.add(repairRepo.updateFrom(device,repair));
            }
        }
        response.setRepairList(repairs);
        return response;
    }

    @Override
    public Device addRepair(Device device, Repair repair) throws RepairAlreadyPresentException {
        if(!isDeviceExist(device)){
            throw new DeviceAbsentException(DEVICE_NAMED+ device.getName() + NOT_EXIST);
        }
        List<Repair> repairs = repairRepo.getFrom(device);
        if(repairs.stream().anyMatch(o -> o.equals(repair)))
            throw new RepairAlreadyPresentException("Repair already exist for Device :" + device.getName());
        device.getRepairList().add(repairRepo.createFrom(device,repair));
        return device;
    }

    @Override
    public Device updateRepair(Device device, Repair repair) throws RepairAbsentException {
        if(!isDeviceExist(device)){
            throw new DeviceAbsentException(DEVICE_NAMED+ device.getName() + NOT_EXIST);
        }
        if(repairRepo.isFromExist(device,repair)){
            device.getRepairList().remove(repair);
            device.getRepairList().add(repairRepo.updateFrom(device,repair));
        } else throw new RepairAbsentException("No reparation for device : " + device.getName());
        return device;
    }
    private boolean isDeviceExist(Device device){
        return !device.getDeviceSerialNumber().isEmpty() || !device.getDeviceSerialNumber().isBlank();
    }
}
