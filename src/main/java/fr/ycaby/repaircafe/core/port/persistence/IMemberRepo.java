package fr.ycaby.repaircafe.core.port.persistence;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Membership;

import java.util.List;

public interface IMemberRepo {
    Member findBySerialNumber(String serialNumber);

    List<Member> search(String label);

    Member createOrUpdate(Member member);

    Membership updateMemberMembership(Member member, Membership membership);

    boolean isMemberMembership(Member member, Membership membership);

    Membership addMemberMembership(Member member, Membership membership);

    List<MemberRoleEnum> getMemberRoles(Member member);

    List<Membership> getMemberMemberships(Member member);

    MemberRoleEnum removeMemberRole(Member member, MemberRoleEnum role);

    MemberRoleEnum addMemberRole(Member member, MemberRoleEnum role);

    List<MemberRoleEnum> getAllRoles();
}
