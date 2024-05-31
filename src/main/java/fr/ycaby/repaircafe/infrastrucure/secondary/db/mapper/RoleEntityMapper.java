package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RoleEntity;


public interface RoleEntityMapper extends GenericSecondaryMapper<MemberRoleEnum, RoleEntity> {
    @Override
    RoleEntity toEntity(MemberRoleEnum domain);

    @Override
    MemberRoleEnum toDomain(RoleEntity entity);
}
