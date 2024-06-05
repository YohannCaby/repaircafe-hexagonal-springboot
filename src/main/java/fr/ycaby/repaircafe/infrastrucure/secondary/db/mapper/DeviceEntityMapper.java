package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.DeviceEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DeviceEntityMapper extends GenericSecondaryMapper<Device, DeviceEntity> {

    @Override
    DeviceEntity toEntity(Device domain);

    @Override
    Device toDomain(DeviceEntity entity);
}
