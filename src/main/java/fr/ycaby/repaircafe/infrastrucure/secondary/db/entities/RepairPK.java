package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class RepairPK {
    String deviceSerialNumber;
    LocalDate date;

}
