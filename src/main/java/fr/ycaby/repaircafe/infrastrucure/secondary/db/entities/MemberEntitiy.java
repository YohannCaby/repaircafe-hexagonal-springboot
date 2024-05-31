package fr.ycaby.repaircafe.infrastrucure.secondary.db.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MemberEntitiy {
    @Id
    String serialNumber;
    String name;
    String surname;
    int birthYear;
}
