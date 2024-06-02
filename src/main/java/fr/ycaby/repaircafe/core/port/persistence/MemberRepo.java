package fr.ycaby.repaircafe.core.port.persistence;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Membership;

import java.util.List;

public interface MemberRepo {
    Member findBySerialNumber(String serialNumber);

    List<Member> search(String label);

    Membership updateMemberMembership(Member member, Membership membership);

    boolean isMemberMembership(Member member, Membership membership);

    Membership addMemberMembership(Member member, Membership membership);

    List<MemberRoleEnum> getMemberRoles(Member member);

    List<Membership> getMemberMemberships(Member member);

    MemberRoleEnum removeMemberRole(Member member, MemberRoleEnum role);

    MemberRoleEnum addMemberRole(Member member, MemberRoleEnum role);

    List<MemberRoleEnum> getAllRoles();

    Member create(Member member);

    Member update(Member member);
}
