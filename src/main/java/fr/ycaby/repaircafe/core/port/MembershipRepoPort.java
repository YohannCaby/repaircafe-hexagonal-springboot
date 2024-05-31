package fr.ycaby.repaircafe.core.port;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Membership;

import java.util.List;

public interface MembershipRepoPort extends IGenericFromPort<Member,Membership> {
    List<Membership> getFrom(Member member);

    boolean isFromExist(Member member, Membership membership);

    Membership updateFrom(Member member, Membership membership);

    Membership createFrom(Member member, Membership membership);

    Membership removeFrom(Member member, Membership membership);
}
