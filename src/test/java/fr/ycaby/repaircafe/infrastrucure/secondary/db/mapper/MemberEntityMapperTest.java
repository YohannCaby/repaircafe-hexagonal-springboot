package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MemberEntitiy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberEntityMapperTest {
    private MemberEntityMapper mapper;

    public MemberEntityMapperTest() {
        this.mapper = new MemberEntityMapperImpl();
    }
    @Test
    public void toMemberDomain(){
        MemberEntitiy entitiy = new MemberEntitiy();
        entitiy.setName("CABY");
        entitiy.setSurname("Yohann");
        entitiy.setMemberSerialNumber("YCAB_1987");
        entitiy.setBirthYear(1987);

        Member member = mapper.toDomain(entitiy);

        Assertions.assertEquals("CABY",member.getName());
        Assertions.assertEquals("Yohann", member.getSurname());
        Assertions.assertEquals("YCAB_1987",member.getMemberSerialNumber());
        Assertions.assertEquals(1987,member.getBirthYear());
    }
    @Test
    public void toEntity(){
        Member member = new Member("CABY","Yohann",1987);

        member.genSerialNumber();

        MemberEntitiy entitiy = mapper.toEntity(member);
        Assertions.assertEquals("CABY",entitiy.getName());
        Assertions.assertEquals("Yohann", entitiy.getSurname());
        Assertions.assertEquals("YCAB_1987",entitiy.getMemberSerialNumber());
        Assertions.assertEquals(1987,entitiy.getBirthYear());


    }

}
