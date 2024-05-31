package fr.ycaby.repaircafe.infrastrucure.secondary.db;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.port.persistence.MemberRoleRepoPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberRoleRepo implements MemberRoleRepoPort {

    @Override
    public List<MemberRoleEnum> getAllRoles() {
        return List.of();
    }

    @Override
    public List<MemberRoleEnum> getFrom(Member member) {
        return List.of();
    }

    @Override
    public boolean isFromExist(Member member, MemberRoleEnum o) {
        return false;
    }

    @Override
    public MemberRoleEnum updateFrom(Member member, MemberRoleEnum o) {
        return null;
    }

    @Override
    public MemberRoleEnum createFrom(Member member, MemberRoleEnum o) {
        return null;
    }

    @Override
    public MemberRoleEnum removeFrom(Member member, MemberRoleEnum o) {
        return null;
    }
}
