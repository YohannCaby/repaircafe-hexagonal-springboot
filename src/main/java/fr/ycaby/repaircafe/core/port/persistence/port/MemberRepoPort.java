package fr.ycaby.repaircafe.core.port.persistence.port;

import fr.ycaby.repaircafe.core.model.Member;

import java.util.List;

public interface MemberRepoPort {

    Member findBySerialNumber(String serialNumber);

    List<Member> search(String label);

    boolean isExist(Member o);

    Member update(Member o);

    Member create(Member o);
}
