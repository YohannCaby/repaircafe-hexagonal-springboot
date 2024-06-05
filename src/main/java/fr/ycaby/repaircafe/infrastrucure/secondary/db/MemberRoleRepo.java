package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.port.persistence.port.MemberRoleRepoPort;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RoleEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RolePK;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.RoleEntityMapperImpl;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.repo.RoleJpaRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberRoleRepo implements MemberRoleRepoPort {
    private final RoleJpaRepo roleJpaRepo;
    private final RoleEntityMapperImpl mapper;

    public MemberRoleRepo(RoleJpaRepo roleJpaRepo, RoleEntityMapperImpl mapper) {
        this.roleJpaRepo = roleJpaRepo;
        this.mapper = mapper;
    }

    @Override
    public List<MemberRoleEnum> getFrom(Member member) {
        return roleJpaRepo.findBySerialNumber(member.getMemberSerialNumber()).stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean isFromExist(Member member, MemberRoleEnum o) {
        return roleJpaRepo.existsById(RolePK.builder()
                .memberSerialNumber(member.getMemberSerialNumber())
                .role(o.name())
                .build());
    }

    @Override
    public MemberRoleEnum updateFrom(Member member, MemberRoleEnum o) {
        return createOrUpdate(member, o);
    }

    @Override
    public MemberRoleEnum createFrom(Member member, MemberRoleEnum o) {
        return createOrUpdate(member, o);
    }

    @Override
    public MemberRoleEnum removeFrom(Member member, MemberRoleEnum o) {
        return null;
    }

    private MemberRoleEnum createOrUpdate(Member member, MemberRoleEnum o) {
        RolePK id = RolePK.builder()
                .memberSerialNumber(member.getMemberSerialNumber())
                .role(o.name())
                .build();
        RoleEntity role = RoleEntity.builder()
                .id(id)
                .build();
        return mapper.toDomain(roleJpaRepo.save(role));
    }
}
