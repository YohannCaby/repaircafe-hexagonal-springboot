package fr.ycaby.repaircafe.configuration;

import fr.ycaby.repaircafe.core.port.persistence.impl.MemberRepoImpl;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.MemberRepo;
import fr.ycaby.repaircafe.core.port.persistence.port.MemberRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.MemberRoleRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.MembershipRepoPort;
import fr.ycaby.repaircafe.core.usecases.MemberUseCase;
import fr.ycaby.repaircafe.core.usecases.Impl.MemberUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    // Secondary Port
    @Bean
    public MemberRepo getMemberRepo(MemberRepoPort memberRepoPort, MembershipRepoPort membershipRepoPort, MemberRoleRepoPort memberRoleRepoPort, DeviceRepoPort deviceRepoPort){
        return new MemberRepoImpl(memberRepoPort,membershipRepoPort,memberRoleRepoPort,deviceRepoPort);
    }
    // Primary Port : Use Cases beans
    @Bean
    public MemberUseCase getMemberApi(MemberRepo memberRepo){
        return new MemberUsecaseImpl(memberRepo);
    }
}
