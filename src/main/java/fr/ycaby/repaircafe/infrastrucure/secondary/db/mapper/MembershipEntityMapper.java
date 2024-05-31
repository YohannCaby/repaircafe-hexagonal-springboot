package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MembershipEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MembershipEntityMapper extends GenericSecondaryMapper<Membership,MembershipEntity> {
    @Override
    @Mapping(target="membershipId.date", source="domain.date")
    MembershipEntity toEntity(Membership domain);

    @Override
    @Mapping(target = "date", source="entity.membershipId.date")
    Membership toDomain(MembershipEntity entity);
}
