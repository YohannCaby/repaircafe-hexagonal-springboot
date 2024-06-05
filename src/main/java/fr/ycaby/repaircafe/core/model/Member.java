package fr.ycaby.repaircafe.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    String name;
    String surname;
    String memberSerialNumber;
    int birthYear;
    List<Device> deviceList;
    List<Membership> membershipList;
    List<MemberRoleEnum> roles;

    public Member(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.deviceList = new ArrayList<>();
        this.membershipList = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    public Membership getLastMembership(){
        return getMembershipList().stream().sorted().toList().getLast();
    }

    public Boolean isValidMembership(){
        Membership lastMembership = getLastMembership();
        return LocalDate.now().isBefore(lastMembership.getExpiration());
    }

    public void genSerialNumber(){
        this.memberSerialNumber = getSurname().substring(0,1).toUpperCase()
                + getName().substring(0,3).toUpperCase()
                +"_"
                + getBirthYear();
    }
}
