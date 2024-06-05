package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import fr.ycaby.repaircafe.core.model.Device;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.DeviceEntity;
import org.junit.jupiter.api.Test;

public class DeviceEntityMapperTest {
    private DeviceEntityMapper mapper;

    public DeviceEntityMapperTest() {
        this.mapper = new DeviceEntityMapperImpl();
    }

    @Test
    public void toDomain(){
        DeviceEntity entity = DeviceEntity.builder()
                .deviceSerialNumber("DEL_20240605")
                .memberSerialNumber("YCAB_1987")
                .name("Laptop")
                .brand("Dell")
                .model("XPS")
                .weight(1.5f)
                .build();
        Device device = mapper.toDomain(entity);
        assertEquals("DEL_20240605",device.getDeviceSerialNumber());
        assertEquals("Laptop",device.getName());
        assertEquals("Dell",device.getBrand());
        assertEquals("XPS",device.getModel());
        assertEquals(1.5f,device.getWeight());
        assertNull(device.getRepairList());
    }
    @Test
    public void toEntity(){
        Device device = new Device("Laptop","Dell","XPS",1.5f);
        device.genSerialNumber();
        DeviceEntity entity = mapper.toEntity(device);
        assertNotNull(entity.getDeviceSerialNumber());
        assertNull(entity.getMemberSerialNumber());
        assertEquals("Laptop",entity.getName());
        assertEquals("Dell",entity.getBrand());
        assertEquals("XPS",entity.getModel());
        assertEquals(1.5f,entity.getWeight());
    }

}
