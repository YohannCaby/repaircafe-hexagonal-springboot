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

public class MemberUseCaseImpl implements MemberUseCase {
    private final static String SERIAL_NUMBER = "Member serial number : ";
    private final MemberRepo memberRepo;

    public MemberUseCaseImpl(MemberRepo memberRepo){
        this.memberRepo = memberRepo;
    }

    /**
     * Add a role to a member : UC 11
     * @param member
     * @param role
     * @return
     * @throws MemberRoleAlreadyPresentException
     */
    @Override
    public Member addRole(Member member, MemberRoleEnum role) throws MemberRoleAlreadyPresentException {
        List<MemberRoleEnum> roles = List.of(MemberRoleEnum.values());
        if(roles.stream().anyMatch(o -> o.equals(role))){
            throw new MemberRoleAlreadyPresentException(SERIAL_NUMBER+ member.getMemberSerialNumber() + " has already role : " + role);
        }
        member.getRoles().add(memberRepo.addMemberRole(member,role));
        return member;
    }

    /**
     * Remove a role from a member : UC 12
     * @param member
     * @param role
     * @return
     * @throws MemberRoleAbsentExpception
     */
    @Override
    public Member removeRole(Member member, MemberRoleEnum role) throws MemberRoleAbsentExpception {
        List<MemberRoleEnum> roles = List.of(MemberRoleEnum.values());
        if(roles.stream().noneMatch(o -> o.equals(role))){
            throw new MemberRoleAbsentExpception(SERIAL_NUMBER+ member.getMemberSerialNumber() + " has no role : " + role);
        }
        member.getRoles().remove(memberRepo.removeMemberRole(member,role));
        return member;
    }

    /**
     * Search for a member by label : UC 00
     * @param label: part of name or surname
     * @return
     */
    @Override
    public List<Member> search(String label) {
        List<Member> members = memberRepo.search(label);
        return Objects.requireNonNullElseGet(members, ArrayList::new);
    }

    /**
     * Create a member : UC 01
     * @param member
     * @return
     * @throws MemberAlreadyPresentException
     */
    @Override
    public Member createMember(Member member) throws MemberAlreadyPresentException {
        if(Objects.isNull(member.getMemberSerialNumber()) || !member.getMemberSerialNumber().isEmpty()){
            member.genSerialNumber();
        } else
            throw new MemberAlreadyPresentException("Member with serial number " + member.getMemberSerialNumber() + " already exist.");
        return memberRepo.create(member);
    }

    /**
     * Update a memeber : UC07
     * @param member
     * @return
     * @throws MemberAbsentException
     */
    @Override
    public Member updateMember(Member member) throws MemberAbsentException {
        if(Objects.isNull(member.getMemberSerialNumber()) || !member.getMemberSerialNumber().isEmpty()){
            throw new MemberAbsentException("Member doesn't exist, cannot be updated");
        }
        return memberRepo.update(member);
    }

    /**
     * Create new membership for a member : UC 05
     * @param member
     * @param membership
     * @return
     * @throws MembershipAlreadyPresentException
     */
    @Override
    public Member addMembership(Member member, Membership membership) throws MembershipAlreadyPresentException {
        member.getMembershipList().add(memberRepo.addMemberMembership(member,membership));
        return member;
    }

    /**
     * Update a membership for a member : UC 10
     * @param member
     * @param membership
     * @return
     * @throws MemberMembershipAbsentException
     */
    @Override
    public Member updateMembership(Member member, Membership membership) throws MemberMembershipAbsentException {
        if(memberRepo.isMemberMembership(member,membership)){
            member.getMembershipList().remove(membership);
            member.getMembershipList().add(memberRepo.updateMemberMembership(member,membership));
        } else {
            throw new MemberMembershipAbsentException(SERIAL_NUMBER+ member.getMemberSerialNumber() + " has no membership to date : " + membership.getDate());
        }
        return member;
    }

}
