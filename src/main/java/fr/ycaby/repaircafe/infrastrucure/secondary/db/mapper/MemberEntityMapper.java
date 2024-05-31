package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MemberEntitiy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MemberEntityMapper extends GenericSecondaryMapper<Member,MemberEntitiy>{
    @Override
    MemberEntitiy toEntity(Member domain);

    @Override
    Member toDomain(MemberEntitiy entity);
}
