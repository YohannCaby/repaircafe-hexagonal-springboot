package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RoleEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RolePK;
import org.junit.jupiter.api.Test;

public class RoleEntityMapperTest {

    private RoleEntityMapperImpl roleEntityMapper;

    public RoleEntityMapperTest() {
        this.roleEntityMapper = new RoleEntityMapperImpl();
    }

    @Test
    public void toDomain(){
        RoleEntity entity = RoleEntity.builder().id(RolePK.builder().memberSerialNumber("YCAB_1987").role("VISITOR").build()).build();
        MemberRoleEnum memberRoleEnum = roleEntityMapper.toDomain(entity);
        assertEquals(MemberRoleEnum.VISITOR, memberRoleEnum);
    }
    @Test
    public void toEntity(){
        MemberRoleEnum memberRoleEnum = MemberRoleEnum.VISITOR;
        RoleEntity entity = roleEntityMapper.toEntity(memberRoleEnum);
        assertEquals("VISITOR", entity.getId().getRole());
        assertNull(entity.getId().getMemberSerialNumber());
    }
}
