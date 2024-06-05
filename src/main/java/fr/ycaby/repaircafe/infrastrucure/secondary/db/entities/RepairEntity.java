package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class RepairEntity {
    @EmbeddedId
    RepairPK id;
    String repairer;
    long repairTime;
    String repairStatus;
    String description;
}
