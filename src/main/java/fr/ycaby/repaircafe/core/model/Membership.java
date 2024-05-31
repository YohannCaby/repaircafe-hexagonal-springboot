package fr.ycaby.repaircafe.core.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class Membership implements Comparable<Membership> {
    LocalDate date;
    LocalDate expiration;
    float paid;

    public Membership(LocalDate date, float paid) {
        this.date = date;
        this.paid = paid;
    }

    public void computeExpirationDate(){
        if(Objects.isNull(getExpiration()))
            setExpiration(getDate().plusYears(1));
    }

    @Override
    public int compareTo(Membership o) {
        return getDate().compareTo(o.getDate());
    }
}
