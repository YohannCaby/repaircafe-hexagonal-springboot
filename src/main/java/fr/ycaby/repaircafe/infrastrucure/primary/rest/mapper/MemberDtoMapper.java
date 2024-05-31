package fr.ycaby.repaircafe.infrastrucure.primary.rest.mapper;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.model.MemberDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MemberDtoMapper extends GenericPrimaryMapper<Member, MemberDto> {

    @Override
    MemberDto toDto(Member domain);

    @Override
    Member toDomain(MemberDto dto);
}
