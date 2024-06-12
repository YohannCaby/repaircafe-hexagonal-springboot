package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RoleEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RolePK;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityMapperImpl implements RoleEntityMapper{

    @Override
    public RoleEntity toEntity(MemberRoleEnum domain) {
        return RoleEntity.builder().id(RolePK.builder().role(domain.name()).build()).build();
    }

    @Override
    public MemberRoleEnum toDomain(RoleEntity entity) {
        return MemberRoleEnum.valueOf(entity.getId().getRole());
    }
}
