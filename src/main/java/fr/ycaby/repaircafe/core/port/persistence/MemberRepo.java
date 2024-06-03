package fr.ycaby.repaircafe.core.port.persistence;

import fr.ycaby.repaircafe.core.exception.MemberRoleAbsentExpception;
import fr.ycaby.repaircafe.core.exception.MemberRoleAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.MembershipAlreadyPresentException;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Membership;

import java.util.List;

public interface MemberRepo {

    List<Member> search(String label);

    Membership updateMemberMembership(Member member, Membership membership) throws MemberRoleAlreadyPresentException;

    boolean isMemberMembership(Member member, Membership membership);

    Membership addMemberMembership(Member member, Membership membership) throws MembershipAlreadyPresentException;

    MemberRoleEnum removeMemberRole(Member member, MemberRoleEnum role) throws MemberRoleAbsentExpception;

    MemberRoleEnum addMemberRole(Member member, MemberRoleEnum role);

    List<MemberRoleEnum> getAllRoles();

    Member create(Member member);

    Member update(Member member);
}
