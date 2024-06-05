package fr.ycaby.repaircafe.core.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Repair implements Comparable<Repair>{
    LocalDate date;
    Member repairer;
    long repairTime;
    RepairStatus repairStatus;
    String description;

    public Repair(Member repairer,LocalDate date) {
        this.repairer = repairer;
        this.date = date;
        this.repairStatus = RepairStatus.UNKNOWN;
    }

    @Override
    public int compareTo(Repair o) {
        return getDate().compareTo(o.getDate());
    }
}
