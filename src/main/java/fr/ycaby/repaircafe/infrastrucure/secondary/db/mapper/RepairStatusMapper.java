package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.RepairStatusEnum;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RepairStatusMapper {

        String toString(RepairStatusEnum status);

        RepairStatusEnum toEnum(String status);

}
