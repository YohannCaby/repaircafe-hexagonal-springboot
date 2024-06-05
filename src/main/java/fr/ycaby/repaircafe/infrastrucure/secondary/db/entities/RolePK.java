package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Builder
@Data
public class RolePK {
    String memberSerialNumber;
    String role;

}
