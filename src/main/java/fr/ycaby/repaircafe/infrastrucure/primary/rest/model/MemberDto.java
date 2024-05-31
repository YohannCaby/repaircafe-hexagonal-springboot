package fr.ycaby.repaircafe.infrastrucure.primary.rest.model;

import lombok.Data;

@Data
public class MemberDto {
    String name;
    String surname;
    String serialNumber;
    int birthYear;
}
