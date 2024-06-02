package fr.ycaby.repaircafe.core.port.persistence.impl;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.MemberRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.MemberRoleRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.MembershipRepoPort;

import java.util.ArrayList;
import java.util.List;

public class MemberRepoImpl implements fr.ycaby.repaircafe.core.port.persistence.MemberRepo {
    private final MemberRepoPort memberRepo;
    private final MembershipRepoPort membershipRepo;
    private final MemberRoleRepoPort roleRepo;
    private final DeviceRepoPort deviceRepo;


    public MemberRepoImpl(MemberRepoPort memberRepo, MembershipRepoPort membershipRepo, MemberRoleRepoPort memberRoleRepo, DeviceRepoPort deviceRepo) {
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

    @Override
    public Member create(Member member) {
        Member response = memberRepo.create(member);
        if(!member.getRoles().isEmpty()){
            List<MemberRoleEnum> roles = new ArrayList<>();
            for(MemberRoleEnum role : member.getRoles()){
                roles.add(roleRepo.createFrom(member,role));
            }
            response.setRoles(roles);
        }
        if(!member.getMembershipList().isEmpty()){
            List<Membership> memberships = new ArrayList<>();
            for(Membership membership:member.getMembershipList()){
                memberships.add(membershipRepo.createFrom(member,membership));
            }
            response.setMembershipList(memberships);
        }
        if(!member.getDeviceList().isEmpty()){
            List<Device> devices = new ArrayList<>();
            for(Device device : member.getDeviceList()){
                devices.add(deviceRepo.createFrom(member,device));
            }
            response.setDeviceList(devices);
        }
        return response;
    }

    @Override
    public Member update(Member member) {
        Member response = memberRepo.update(member);
        if(!member.getRoles().isEmpty()){
            List<MemberRoleEnum> roles = new ArrayList<>();
            for(MemberRoleEnum role : member.getRoles()){
                roles.add(roleRepo.updateFrom(member,role));
            }
            response.setRoles(roles);
        }
        if(!member.getMembershipList().isEmpty()){
            List<Membership> memberships = new ArrayList<>();
            for(Membership membership:member.getMembershipList()){
                memberships.add(membershipRepo.updateFrom(member,membership));
            }
            response.setMembershipList(memberships);
        }
        if(!member.getDeviceList().isEmpty()){
            List<Device> devices = new ArrayList<>();
            for(Device device : member.getDeviceList()){
                devices.add(deviceRepo.updateFrom(member,device));
            }
            response.setDeviceList(devices);
        }
        return response;
    }


}
