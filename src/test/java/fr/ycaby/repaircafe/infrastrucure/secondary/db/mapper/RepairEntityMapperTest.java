package fr.ycaby.repaircafe.infrastrucure.secondary.db.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.ycaby.repaircafe.core.model.Member;
import fr.ycaby.repaircafe.core.model.Repair;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RepairEntity;
import fr.ycaby.repaircafe.infrastrucure.secondary.db.entities.RepairPK;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class RepairEntityMapperTest {
    RepairEntityMapper repairEntityMapper;

    public RepairEntityMapperTest() {
        this.repairEntityMapper = new RepairEntityMapperImpl();
    }

    @Test
    public void toDomain(){
        RepairEntity entity = RepairEntity.builder().id(
                RepairPK.builder().date(LocalDate.of(2021, 1, 1)).build()).repairer("YCAB_1987").build();
        Repair repair = repairEntityMapper.toDomain(entity);
        assertEquals(LocalDate.of(2021, 1, 1), repair.getDate());
        assertEquals("YCAB_1987", repair.getRepairer().getMemberSerialNumber());
    }

    @Test
    public void toEntity(){
        Repair repair = Repair.builder().date(LocalDate.of(2021, 1, 1)).repairer(Member.builder().memberSerialNumber("YCAB_1987").build()).build();
        RepairEntity entity = repairEntityMapper.toEntity(repair);
        assertEquals(LocalDate.of(2021, 1, 1), entity.getId().getDate());
        assertEquals("YCAB_1987", entity.getRepairer());
    }

}
