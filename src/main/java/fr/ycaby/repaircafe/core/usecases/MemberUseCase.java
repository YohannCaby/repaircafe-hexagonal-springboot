package fr.ycaby.repaircafe.core.usecases;

import fr.ycaby.repaircafe.core.exception.MemberAbsentException;
import fr.ycaby.repaircafe.core.exception.MemberAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.MemberMembershipAbsentException;
import fr.ycaby.repaircafe.core.exception.MembershipAlreadyPresentException;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.exception.MemberRoleAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.MemberRoleAbsentExpception;

import fr.ycaby.repaircafe.core.model.Membership;
import java.util.List;

public interface MemberUseCase {
    Member addRole(Member member, MemberRoleEnum role) throws MemberRoleAlreadyPresentException;
    List<MemberRoleEnum> getRoles();
    Member removeRole(Member member, MemberRoleEnum role) throws MemberRoleAbsentExpception;
    List<Member> search(String label);
    Member updateMember(Member domain) throws MemberAbsentException;
    Member createMember(Member domain) throws MemberAlreadyPresentException;
    Member addMembership(Member member, Membership membership) throws MembershipAlreadyPresentException;
    Member updateMembership(Member member, Membership membership) throws MemberMembershipAbsentException;
}
