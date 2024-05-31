package fr.ycaby.repaircafe.core.port.persistence.impl;

import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.core.port.persistence.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.MemberRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.MemberRoleRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.MembershipRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.IMemberRepo;

import java.util.ArrayList;
import java.util.List;

public class MemberRepo implements IMemberRepo {
    private final MemberRepoPort memberRepo;
    private final MembershipRepoPort membershipRepo;
    private final MemberRoleRepoPort roleRepo;
    private final DeviceRepoPort deviceRepo;


    public MemberRepo(MemberRepoPort memberRepo, MembershipRepoPort membershipRepo, MemberRoleRepoPort memberRoleRepo, DeviceRepoPort deviceRepo) {
        this.memberRepo = memberRepo;
        this.membershipRepo = membershipRepo;
        this.roleRepo = memberRoleRepo;
        this.deviceRepo = deviceRepo;
    }
    @Override
    public Member findBySerialNumber(String serialNumber) {
        Member member = memberRepo.findBySerialNumber(serialNumber);
        member.setMembershipList(membershipRepo.getFrom(member));
        member.setDeviceList(deviceRepo.getFrom(member));
        member.setRoles(roleRepo.getFrom(member));
        return member;
    }

    @Override
    public List<Member> search(String label) {
        List<Member> members = memberRepo.search(label);
        members.forEach(o -> {
            o.setMembershipList(new ArrayList<>());
            o.setDeviceList(new ArrayList<>());
            o.setRoles(List.of(MemberRoleEnum.UNKNOWN));
        });
        return members;
    }

    @Override
    public Member createOrUpdate(Member member) {
        if (memberRepo.isExist(member)) {
            return memberRepo.update(member);
        } else {
            return memberRepo.create(member);
        }
    }

    @Override
    public Membership updateMemberMembership(Member member, Membership membership) {
        return membershipRepo.updateFrom(member,membership);

    }

    @Override
    public boolean isMemberMembership(Member member, Membership membership) {
        return membershipRepo.isFromExist(member,membership);
    }

    @Override
    public Membership addMemberMembership(Member member, Membership membership) {
        return membershipRepo.createFrom(member,membership);
    }

    @Override
    public List<MemberRoleEnum> getMemberRoles(Member member) {
        return roleRepo.getFrom(member);
    }

    @Override
    public List<Membership> getMemberMemberships(Member member) {
        return membershipRepo.getFrom(member);
    }

    @Override
    public MemberRoleEnum removeMemberRole(Member member, MemberRoleEnum role) {
        return roleRepo.removeFrom(member,role);
    }

    @Override
    public MemberRoleEnum addMemberRole(Member member, MemberRoleEnum role) {
        return roleRepo.createFrom(member,role);
    }

    @Override
    public List<MemberRoleEnum> getAllRoles() {
        return roleRepo.getAllRoles();
    }


}
