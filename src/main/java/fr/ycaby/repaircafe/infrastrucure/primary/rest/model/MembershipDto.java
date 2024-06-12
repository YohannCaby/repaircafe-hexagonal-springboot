package fr.ycaby.repaircafe.infrastrucure.primary.rest.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class MembershipDto {
    MemberDto member;
    LocalDate date;
    LocalDate expiration;
    float paid;
}
