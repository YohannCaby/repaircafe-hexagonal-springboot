package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class DeviceEntity {
    @Id
    String deviceSerialNumber;
    String memberSerialNumber;
    String name;
    String brand;
    String model;
    float weight;
}
