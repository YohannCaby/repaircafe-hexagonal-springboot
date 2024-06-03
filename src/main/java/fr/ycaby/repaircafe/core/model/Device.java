package fr.ycaby.repaircafe.core.model;

import fr.ycaby.repaircafe.core.exception.RepairListAbsentException;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Device {
    String name;
    String brand;
    String model;
    float weight;
    List<Repair> repairList;

    public Device(String name, String brand, String model, float weight) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.weight = weight;
    }

    public RepairStatus getCurrentKnowRepairStatus() throws RepairListAbsentException {
        if(Objects.isNull(getRepairList())) {
            throw new RepairListAbsentException("No repair list for device " + getName());
        }
        if(getRepairList().isEmpty()){
            throw new RepairListAbsentException("Repair list is empty for device " + getName());
        }
        return getRepairList().stream().sorted().toList().getFirst().getRepairStatus();
    }
}
