package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.Repair;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RepairEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RepairEntityMapper extends GenericSecondaryMapper<Repair, RepairEntity>{

    @Override
    @Mapping(target = "id.date", source = "domain.date")
    @Mapping(target = "repairer", source = "domain.repairer.memberSerialNumber")
    RepairEntity toEntity(Repair domain);

    @Override
    @Mapping(target = "date", source = "entity.id.date")
    @Mapping(target = "repairer.memberSerialNumber", source = "entity.repairer")
    Repair toDomain(RepairEntity entity);
}
