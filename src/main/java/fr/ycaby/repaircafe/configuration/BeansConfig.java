package fr.ycaby.repaircafe.configuration;

import fr.ycaby.repaircafe.core.port.persistence.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.IMemberRepo;
import fr.ycaby.repaircafe.core.port.persistence.MemberRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.MemberRoleRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.MembershipRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.impl.MemberRepo;
import fr.ycaby.repaircafe.core.usecases.IMemberApi;
import fr.ycaby.repaircafe.core.usecases.Impl.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    // Secondary Port
    @Bean
    public IMemberRepo getMemberRepo(MemberRepoPort memberRepoPort, MembershipRepoPort membershipRepoPort, MemberRoleRepoPort memberRoleRepoPort, DeviceRepoPort deviceRepoPort){
        return new MemberRepo(memberRepoPort,membershipRepoPort,memberRoleRepoPort,deviceRepoPort);
    }
    // Primary Port : Use Cases beans
    @Bean
    public IMemberApi getMemberApi(IMemberRepo memberRepo){
        return new MemberService(memberRepo);
    }
}
