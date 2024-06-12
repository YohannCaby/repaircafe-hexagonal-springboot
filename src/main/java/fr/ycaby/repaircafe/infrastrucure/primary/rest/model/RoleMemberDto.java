package fr.ycaby.repaircafe.infrastrucure.primary.rest.model;

import lombok.Data;

@Data
public class RoleMemberDto {
    MemberDto member;
    String role;
}
