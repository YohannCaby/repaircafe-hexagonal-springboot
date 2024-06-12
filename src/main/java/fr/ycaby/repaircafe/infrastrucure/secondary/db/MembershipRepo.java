package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.MembershipEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.MembershipEntityMapper;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.repo.MembershipJpaRepo;
import fr.ycaby.repaircafe.core.port.persistence.port.MembershipRepoPort;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MembershipRepo implements MembershipRepoPort {
    private final MembershipJpaRepo membershipJpaRepo;
    private final MembershipEntityMapper mapper;

    public MembershipRepo(MembershipJpaRepo membershipJpaRepo, MembershipEntityMapper mapper) {
        this.membershipJpaRepo = membershipJpaRepo;
        this.mapper = mapper;
    }

    @Override
    public List<Membership> getFrom(Member member) {
        return membershipJpaRepo.findBySerialNumber(member.getMemberSerialNumber()).stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean isFromExist(Member member, Membership membership) {
        MembershipEntity entity = mapToEntity(member,membership);
        return membershipJpaRepo.existsById(entity.getId());
    }

    @Override
    public Membership updateFrom(Member member, Membership membership) {
        return createOrUpdate(member, membership);
    }

    @Override
    public Membership createFrom(Member member, Membership membership) {
        return createOrUpdate(member, membership);
    }

    @Override
    public Membership removeFrom(Member member, Membership membership) {
        MembershipEntity entity = mapToEntity(member,membership);
        membershipJpaRepo.delete(entity);
        return membership;
    }

    private MembershipEntity mapToEntity(Member member, Membership membership){
        MembershipEntity membershipEntity = mapper.toEntity(membership);
        membershipEntity.getId().setMemberSerialNumber(member.getMemberSerialNumber());
        return membershipEntity;
    }

    private Membership createOrUpdate(Member member, Membership membership) {
        MembershipEntity entity = mapToEntity(member,membership);
        return mapper.toDomain(membershipJpaRepo.save(entity));
    }
}
