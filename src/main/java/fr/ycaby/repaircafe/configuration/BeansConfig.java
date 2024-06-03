package fr.ycaby.repaircafe.configuration;

import fr.ycaby.repaircafe.core.port.persistence.DeviceRepo;
import fr.ycaby.repaircafe.core.port.persistence.impl.DeviceRepoImpl;
import fr.ycaby.repaircafe.core.port.persistence.impl.MemberRepoImpl;
import fr.ycaby.repaircafe.core.port.persistence.port.DeviceRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.MemberRepo;
import fr.ycaby.repaircafe.core.port.persistence.port.MemberRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.MemberRoleRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.MembershipRepoPort;
import fr.ycaby.repaircafe.core.port.persistence.port.RepairRepoPort;
import fr.ycaby.repaircafe.core.usecases.DeviceUseCase;
import fr.ycaby.repaircafe.core.usecases.Impl.DeviceUseCaseImpl;
import fr.ycaby.repaircafe.core.usecases.MemberUseCase;
import fr.ycaby.repaircafe.core.usecases.Impl.MemberUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    // Secondary Port
    @Bean
    public MemberRepo getMemberRepo(MemberRepoPort memberRepoPort, MembershipRepoPort membershipRepoPort, MemberRoleRepoPort memberRoleRepoPort, DeviceRepoPort deviceRepoPort){
        return new MemberRepoImpl(memberRepoPort,membershipRepoPort,memberRoleRepoPort,deviceRepoPort);
    }
    @Bean
    public DeviceRepo getDeviceRepo(DeviceRepoPort deviceRepoPort, RepairRepoPort repairRepoPort){
        return new DeviceRepoImpl(deviceRepoPort,repairRepoPort);
    }
    // Primary Port : Use Cases beans
    @Bean
    public MemberUseCase getMemberApi(MemberRepo memberRepo){
        return new MemberUseCaseImpl(memberRepo);
    }
    @Bean
    DeviceUseCase getDeviceApi(DeviceRepo deviceRepo){
        return new DeviceUseCaseImpl(deviceRepo);
    }
}
