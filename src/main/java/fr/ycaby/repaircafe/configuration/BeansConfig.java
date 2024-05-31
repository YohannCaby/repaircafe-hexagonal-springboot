package fr.ycaby.repaircafe.configuration;

import fr.ycaby.repaircafe.core.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.MemberRepoPort;
import fr.ycaby.repaircafe.core.port.MemberRoleRepoPort;
import fr.ycaby.repaircafe.core.port.MembershipRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.IMemberRepo;
import fr.ycaby.repaircafe.core.port.persistence.impl.MemberRepo;
import fr.ycaby.repaircafe.core.usecases.IMemberApi;
import fr.ycaby.repaircafe.core.usecases.Impl.MemberService;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.MemberEntityMapper;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.MembershipEntityMapper;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper.RoleEntityMapper;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.repo.MemberJpaRepo;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.repo.MembershipJpaRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    private final MemberJpaRepo memberJpaRepo;

    private final MembershipJpaRepo membershipJpaRepo;

    private final MemberEntityMapper memberEntityMapper;

    private final MembershipEntityMapper membershipEntityMapper;

    private final RoleEntityMapper roleEntityMapper;

    private final IMemberRepo memberRepo;

    private final MemberRepoPort memberRepoPort;

    private final MembershipRepoPort membershipRepoPort;

    private final MemberRoleRepoPort memberRoleRepoPort;

    private final DeviceRepoPort deviceRepoPort;

    public BeansConfig(MemberJpaRepo memberJpaRepo, MembershipJpaRepo membershipJpaRepo, MemberEntityMapper memberEntityMapper, MembershipEntityMapper membershipEntityMapper, RoleEntityMapper roleEntityMapper, IMemberRepo memberRepo, MemberRepoPort memberRepoPort, MembershipRepoPort membershipRepoPort, MemberRoleRepoPort memberRoleRepoPort, DeviceRepoPort deviceRepoPort) {
        this.memberJpaRepo = memberJpaRepo;
        this.membershipJpaRepo = membershipJpaRepo;
        this.memberEntityMapper = memberEntityMapper;
        this.membershipEntityMapper = membershipEntityMapper;
        this.roleEntityMapper = roleEntityMapper;
        this.memberRepo = memberRepo;
        this.memberRepoPort = memberRepoPort;
        this.membershipRepoPort = membershipRepoPort;
        this.memberRoleRepoPort = memberRoleRepoPort;
        this.deviceRepoPort = deviceRepoPort;
    }


    @Bean
    public IMemberApi getMemberApi(){
        return new MemberService(memberRepo);
    }
    @Bean
    public IMemberRepo getMemberRepo(){
        return new MemberRepo(memberRepoPort,membershipRepoPort,memberRoleRepoPort,deviceRepoPort);
    }
    @Bean
    public MemberRepoPort getMemberRepoPort(){
        return new fr.ycaby.repaircafe.infrastrucure.secondary.db.MemberRepo(memberJpaRepo,memberEntityMapper);
    }
}
