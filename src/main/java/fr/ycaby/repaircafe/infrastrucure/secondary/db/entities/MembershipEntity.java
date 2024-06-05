package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MembershipEntity {
    @EmbeddedId
    MembershipPK id;
    LocalDate expiration;
    float paid;
}
