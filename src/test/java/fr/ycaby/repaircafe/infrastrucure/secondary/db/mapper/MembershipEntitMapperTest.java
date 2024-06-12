package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MembershipEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MembershipPK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MembershipEntitMapperTest {
    private MembershipEntityMapper mapper;

    public MembershipEntitMapperTest() {
        this.mapper= new MembershipEntityMapperImpl();
    }
    @Test
    public void toMembershipEntity(){
        Member member = new Member("CABY","Yohann",1987);
        member.genSerialNumber();
        Membership membership = new Membership(LocalDate.of(2024,5,21),7);
        membership.computeExpirationDate();
        member.getMembershipList().add(membership);
        MembershipEntity entity = mapper.toEntity(membership);

        Assertions.assertEquals(LocalDate.of(2024,5,21),entity.getId().getDate());
        Assertions.assertEquals(7,entity.getPaid());
        Assertions.assertEquals(LocalDate.of(2025,5,21),entity.getExpiration());
    }

    @Test
    public void toMemberDomain(){
        MembershipEntity entity = new MembershipEntity();
        entity.setExpiration(LocalDate.of(2025,5,21));
        entity.setPaid(7);
        MembershipPK id = new MembershipPK();
        id.setMemberSerialNumber("YCAB_1987");
        id.setDate(LocalDate.of(2024,5,21));
        entity.setId(id);

        Membership member = mapper.toDomain(entity);

        Assertions.assertEquals(7,member.getPaid());
        Assertions.assertEquals(LocalDate.of(2025,5,21),member.getExpiration());
        Assertions.assertEquals(LocalDate.of(2024,5,21),member.getDate());
    }
}
