package fr.ycaby.repaircafe.infrastrucure.primary.rest.mapper;

import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.model.MembershipDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MembershipDtoMapper extends GenericPrimaryMapper<Membership, MembershipDto> {

    @Override
    MembershipDto toDto(Membership domain);

    @Override
    Membership toDomain(MembershipDto dto);
}
