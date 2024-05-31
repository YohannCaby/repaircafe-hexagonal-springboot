package fr.ycaby.repaircafe.core.port.persistence;

import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Member;

import java.util.List;

public interface MemberRoleRepoPort extends IGenericFromPort<Member,MemberRoleEnum> {
    List<MemberRoleEnum> getAllRoles();
}
