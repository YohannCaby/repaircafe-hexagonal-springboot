package fr.ycaby.repaircafe.core.model;

import fr.ycaby.repaircafe.core.exception.RepairListAbsentException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import org.apache.catalina.util.StringUtil;
import org.mapstruct.ap.internal.util.Strings;
import org.springframework.util.StringUtils;

@Data
public class Device {
    public static final String UNKNOWN_BRAND = "Unknown";
    String deviceSerialNumber;
    String name;
    String brand;
    String model;
    float weight;
    List<Repair> repairList;

    public Device(String name, String brand, String model, float weight) {
        this.name = name;
        if(brand == null || brand.isEmpty() || brand.isBlank()){
            this.brand = UNKNOWN_BRAND;
        } else {
            this.brand = brand;
        }
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

    public void genSerialNumber(){
        this.deviceSerialNumber = getBrand().substring(0,3).toUpperCase() + "_" +String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }
}
