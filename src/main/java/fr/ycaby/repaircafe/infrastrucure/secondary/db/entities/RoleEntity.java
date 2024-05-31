package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class RoleEntity {
    @EmbeddedId
    RolePK id;
}
