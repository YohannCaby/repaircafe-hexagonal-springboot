package fr.ycaby.repaircafe.core.usecases.Impl;

import fr.ycaby.repaircafe.core.exception.*;
import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.core.usecases.MemberUseCase;
import fr.ycaby.repaircafe.core.port.persistence.MemberRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemberUsecaseImpl implements MemberUseCase {

    private final MemberRepo memberRepo;

    public MemberUsecaseImpl(MemberRepo memberRepo){
        this.memberRepo = memberRepo;
    }

    @Override
    public List<MemberRoleEnum> getRoles() {
        return memberRepo.getAllRoles();
    }

    @Override
    public Member addRole(Member member, MemberRoleEnum role) throws MemberRoleAlreadyPresentException {
        List<MemberRoleEnum> roles = memberRepo.getMemberRoles(member);
        if(roles.stream().anyMatch(o -> o.equals(role))){
            throw new MemberRoleAlreadyPresentException("Member serial number : "+ member.getSerialNumber() + " has already role : " + role);
        }
        member.getRoles().add(memberRepo.addMemberRole(member,role));
        return member;
    }

    @Override
    public Member removeRole(Member member, MemberRoleEnum role) throws NoMemberRolePresentExpception {
        List<MemberRoleEnum> roles = memberRepo.getMemberRoles(member);
        if(roles.stream().noneMatch(o -> o.equals(role))){
            throw new NoMemberRolePresentExpception("Member serial number : "+ member.getSerialNumber() + " has no role : " + role);
        }
        member.getRoles().remove(memberRepo.removeMemberRole(member,role));
        return member;
    }

    @Override
    public Member findBySerialNumber(String serialNumber) {
        Member member = memberRepo.findBySerialNumber(serialNumber);
        member.setMembershipList(memberRepo.getMemberMemberships(member));
        member.setRoles(memberRepo.getMemberRoles(member));
        return member;
    }

    @Override
    public List<Member> search(String label) {
        List<Member> members = memberRepo.search(label);
        if(members == null){
            return new ArrayList<>();
        } else {
            return members;
        }
    }

    @Override
    public Member updateMember(Member member) throws MemberAbsentException {
        if(Objects.isNull(member.getSerialNumber()) || !member.getSerialNumber().isEmpty()){
            throw new MemberAbsentException("Member doesn't exist, cannot be updated");
        }

        return memberRepo.update(member);
    }

    @Override
    public Member createMember(Member member) throws MemberAlreadyPresentException {
        if(Objects.isNull(member.getSerialNumber()) || !member.getSerialNumber().isEmpty()){
            member.genSerialNumber();
        } else
            throw new MemberAlreadyPresentException("Member with serial number " + member.getSerialNumber() + " already exist.");
        return memberRepo.create(member);
    }

    public Member addMembership(Member member, Membership membership) throws MembershipAlreadyPresentException {
        List<Membership> memberships = memberRepo.getMemberMemberships(member);
        if(memberships.stream().anyMatch(o -> o.equals(membership))){
            throw new MembershipAlreadyPresentException("Member serial number : "+ member.getSerialNumber() + " has already membership to date : " + membership.getDate());
        }
        member.getMembershipList().add(memberRepo.addMemberMembership(member,membership));
        return member;
    }

    public Member updateMembership(Member member, Membership membership) throws NoMemberMembershipPresentException{
        if(memberRepo.isMemberMembership(member,membership)){
            member.getMembershipList().remove(membership);
            member.getMembershipList().add(membership);
            memberRepo.updateMemberMembership(member,membership);
        } else {
            throw new NoMemberMembershipPresentException("Member serial number : "+ member.getSerialNumber() + " has no membership to date : " + membership.getDate());
        }
        return member;
    }


}
