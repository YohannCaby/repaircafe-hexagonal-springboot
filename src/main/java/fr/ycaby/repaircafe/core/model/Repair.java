package fr.ycaby.repaircafe.core.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Repair implements Comparable<Repair>{
    LocalDateTime date;
    Member repairer;
    long repairTime;
    RepairStatus repairStatus;
    String description;
    Device device;
    Member visitor;

    public Repair(Member repairer, Device device, Member visitor) {
        this.repairer = repairer;
        this.repairStatus = RepairStatus.UNKNOWN;
        this.device = device;
        this.visitor = visitor;


    }

    @Override
    public int compareTo(Repair o) {
        return getDate().compareTo(o.getDate());
    }
}
