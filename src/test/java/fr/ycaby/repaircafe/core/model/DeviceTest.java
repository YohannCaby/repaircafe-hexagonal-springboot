package fr.ycaby.repaircafe.core.model;

import fr.ycaby.repaircafe.core.exception.NoRepairListException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DeviceTest {

    @Test
    public void deviceNoRepairListExceptionTest(){
        Device device = new Device("Tea pot","Mumy","old one",1500);
        NoRepairListException exception = Assertions.assertThrowsExactly(NoRepairListException.class, device::getCurrentKnowRepairStatus);
        Assertions.assertEquals("No repair list for device " + device.getName(),exception.getMessage());
        device.setRepairList(new ArrayList<>());
        exception = Assertions.assertThrowsExactly(NoRepairListException.class, device::getCurrentKnowRepairStatus);
        Assertions.assertEquals("Repair list is empty for device " + device.getName(),exception.getMessage());
    }
}
