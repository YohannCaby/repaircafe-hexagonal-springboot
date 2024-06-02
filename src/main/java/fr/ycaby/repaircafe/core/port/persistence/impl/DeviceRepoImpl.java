package fr.ycaby.repaircafe.core.port.persistence.impl;

import fr.ycaby.repaircafe.core.exception.NoRepairPresentException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyPresentException;
import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.RepairRepoPort;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepoImpl implements fr.ycaby.repaircafe.core.port.persistence.DeviceRepo {

    private final DeviceRepoPort deviceRepo;

    private final RepairRepoPort repairRepo;

    public DeviceRepoImpl(DeviceRepoPort deviceRepo, RepairRepoPort repairRepo) {
        this.deviceRepo = deviceRepo;
        this.repairRepo = repairRepo;
    }


    @Override
    public Device create(Member member, Device device) {
        Device response = deviceRepo.createFrom(member,device);
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
    public Device update(Member member, Device device) {
        Device response = deviceRepo.updateFrom(member,device);
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
        List<Repair> repairs = repairRepo.getFrom(device);
        if(repairs.stream().anyMatch(o -> o.equals(repair)))
            throw new RepairAlreadyPresentException("Repair already exist for Device :" + device.getName());
        device.getRepairList().add(repairRepo.createFrom(device,repair));
        return device;
    }

    @Override
    public Device updateRepair(Device device, Repair repair) throws NoRepairPresentException {
        if(repairRepo.isFromExist(device,repair)){
            device.getRepairList().remove(repair);
            device.getRepairList().add(repairRepo.updateFrom(device,repair));
        } else throw new NoRepairPresentException("No reparation for device : " + device.getName());
        return device;
    }
}
