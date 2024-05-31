package fr.ycaby.repaircafe.infrastrucure.primary.rest;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.usecases.IMemberApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/member")
public class MemberRestControlerImpl {

    private final IMemberApi memberApi;

    public MemberRestControlerImpl(IMemberApi memberApi) {
        this.memberApi = memberApi;
    }

    @PostMapping("")
    public Member save(Member member) {
        return memberApi.saveOrUpdateMember(member);
    }

    @GetMapping("")
    public List<Member> getAll(@RequestParam("search") String label){ return memberApi.search(label);}
}
