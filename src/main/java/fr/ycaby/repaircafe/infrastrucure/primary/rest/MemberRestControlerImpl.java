package fr.ycaby.repaircafe.infrastrucure.primary.rest;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.MemberRoleEnum;
import fr.ycaby.repaircafe.core.model.Membership;
import fr.ycaby.repaircafe.core.usecases.MemberUseCase;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.mapper.MemberDtoMapper;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.mapper.MembershipDtoMapper;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.model.MemberDto;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.model.MembershipDto;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.model.RoleMemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/members")
public class MemberRestControlerImpl {

    private final MemberUseCase memberUseCase;
    private final MemberDtoMapper memberMapper;
    private final MembershipDtoMapper membershipMapper;

    public MemberRestControlerImpl(MemberUseCase memberApi, MemberDtoMapper mapper,
            MembershipDtoMapper membershipMapper) {
        this.memberUseCase = memberApi;
        this.memberMapper = mapper;
        this.membershipMapper = membershipMapper;
    }

    @PostMapping(value="",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDto> save(@RequestBody() MemberDto member) {
        return new ResponseEntity<>(memberMapper.toDto(memberUseCase.updateMember(memberMapper.toDomain(member))), HttpStatus.OK);
    }

    @PutMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDto> create(@RequestBody() MemberDto member){
        return new ResponseEntity<>(memberMapper.toDto(memberUseCase.createMember(memberMapper.toDomain(member))), HttpStatus.OK);
    }

    @GetMapping(value="",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemberDto>> getAll(@RequestParam("search") String label){
        List<Member> members = memberUseCase.search(label);
        List<MemberDto> dtos = members.stream().map(memberMapper::toDto).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(value="/addRole",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleMemberDto> addRole(@RequestBody() RoleMemberDto roleMember){
        Member member = memberMapper.toDomain(roleMember.getMember());
        MemberRoleEnum role = MemberRoleEnum.valueOf(roleMember.getRole());
        member = memberUseCase.addRole(member, role);
        RoleMemberDto dto = new RoleMemberDto();
        dto.setMember(memberMapper.toDto(member));
        dto.setRole(role.toString());
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @DeleteMapping(value="/removeRole",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleMemberDto> removeRole(@RequestBody() RoleMemberDto roleMember){
        Member member = memberMapper.toDomain(roleMember.getMember());
        MemberRoleEnum role = MemberRoleEnum.valueOf(roleMember.getRole());
        member = memberUseCase.removeRole(member, role);
        RoleMemberDto dto = new RoleMemberDto();
        dto.setMember(memberMapper.toDto(member));
        dto.setRole(role.toString());
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PutMapping(value="/addMembership",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembershipDto> addMembership(@RequestBody() MembershipDto membershipDto){
        Member member = memberMapper.toDomain(membershipDto.getMember());
        Membership membership = new Membership(membershipDto.getDate(),membershipDto.getPaid());
        member = memberUseCase.addMembership(member, membership);
        MembershipDto dto = membershipMapper.toDto(membership);
        dto.setMember(memberMapper.toDto(member));
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @PostMapping(value="/updateMembership",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembershipDto> updateMembership(@RequestBody() MembershipDto membershipDto){
        Member member = memberMapper.toDomain(membershipDto.getMember());
        Membership membership = new Membership(membershipDto.getDate(),membershipDto.getPaid());
        member = memberUseCase.updateMembership(member, membership);
        MembershipDto dto = membershipMapper.toDto(membership);
        dto.setMember(memberMapper.toDto(member));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
