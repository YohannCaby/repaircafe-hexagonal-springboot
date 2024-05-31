package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.DataSizeUnit;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
