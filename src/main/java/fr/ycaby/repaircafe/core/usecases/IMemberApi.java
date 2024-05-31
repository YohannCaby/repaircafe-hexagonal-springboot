package fr.ycaby.repaircafe.core.usecases;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.exception.MemberRoleAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.NoMemberRolePresentExpception;

import java.util.List;

public interface IMemberApi {
    Member saveOrUpdateMember(Member member);
    Member addRole(Member member, MemberRoleEnum role) throws MemberRoleAlreadyPresentException;
    List<MemberRoleEnum> getRoles();
    Member removeRole(Member member, MemberRoleEnum role) throws NoMemberRolePresentExpception;

    Member findBySerialNumber(String serialNumbe);
    List<Member> search(String label);
}
