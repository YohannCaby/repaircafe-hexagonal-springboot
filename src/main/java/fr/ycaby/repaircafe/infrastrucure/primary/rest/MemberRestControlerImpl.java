package fr.ycaby.repaircafe.infrastrucure.primary.rest;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.usecases.IMemberApi;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.mapper.MemberDtoMapper;
import fr.ycaby.repaircafe.infrastrucure.primary.rest.model.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/members")
public class MemberRestControlerImpl {

    private final IMemberApi memberApi;
    private final MemberDtoMapper mapper;

    public MemberRestControlerImpl(IMemberApi memberApi, MemberDtoMapper mapper) {
        this.memberApi = memberApi;
        this.mapper = mapper;
    }

    @PostMapping(value="",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDto> save(@RequestBody() MemberDto member) {
        return new ResponseEntity<>(mapper.toDto(memberApi.saveOrUpdateMember(mapper.toDomain(member))), HttpStatus.OK);
    }

    @GetMapping(value="",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemberDto>> getAll(@RequestParam("search") String label){
        List<Member> members = memberApi.search(label);
        List<MemberDto> dtos = members.stream().map(mapper::toDto).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);}
}
