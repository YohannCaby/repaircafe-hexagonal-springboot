package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.port.persistence.MemberRepoPort;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.MemberEntityMapper;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.repo.MemberJpaRepo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberPersistenceRepo implements MemberRepoPort {
    private final MemberJpaRepo memberJpaRepo;
    private final MemberEntityMapper mapper;

    public MemberPersistenceRepo(MemberJpaRepo memberJpaRepo, MemberEntityMapper mapper) {
        this.memberJpaRepo = memberJpaRepo;
        this.mapper = mapper;
    }

    @Override
    public Member findBySerialNumber(String serialNumber) {
        return mapper.toDomain(memberJpaRepo.findBySerialNumber(serialNumber).stream().findFirst().get());
    }

    @Override
    public List<Member> search(String label) {
        return memberJpaRepo.findByNameContainingOrSurnameContaining(label,label)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Member save(Member o) {
        return mapper.toDomain(memberJpaRepo.save(mapper.toEntity(o)));
    }

    @Override
    public boolean isExist(Member o) {
        return memberJpaRepo.existsBySerialNumber(o.getSerialNumber());
    }

    @Override
    public Member update(Member o) {
        return save(o);
    }

    @Override
    public Member create(Member o) {
        return save(o);
    }
}
