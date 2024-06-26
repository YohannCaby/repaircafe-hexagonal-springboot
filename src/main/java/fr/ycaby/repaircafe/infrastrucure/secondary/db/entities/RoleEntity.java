package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class RoleEntity {
    @EmbeddedId
    RolePK id;
}
