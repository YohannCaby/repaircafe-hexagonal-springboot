package fr.ycaby.repaircafe.core.model;

public class MemberTest {
    /*@Test
    public void VisitorConstructorTest(){
        Visitor visitor = new Visitor("CABY","Yohann",1987);
        Assertions.assertEquals("VIS_YCAB_1987",visitor.getMemberSerialNumber());
    }
    @Test
    public void RepairerConstructorTest(){
        Repairer repairer = new Repairer("CABY","Yohann",1987);
        Assertions.assertEquals("REP_YCAB",repairer.getMemberSerialNumber());
    }
    @Test
    public void ReceptionistConstructorTest(){
        Receptionist repairer = new Receptionist("CABY","Yohann",1987);
        Assertions.assertEquals("REP_YCAB",repairer.getMemberSerialNumber());
    }
    @Test
    public void MembershipTest(){
        List<Membership> membershipList = List.of(
                new Membership(LocalDate.of(2022,3,2),7),
                new Membership(LocalDate.of(2023,3,2),7),
                new Membership(LocalDate.now(),7),
                new Membership(LocalDate.of(2021,3,2),7));
        membershipList.forEach(Membership::computeExpirationDate);
        Visitor visitor = new Visitor("CABY","Yohann",1987);
        visitor.setMembershipList(membershipList);
        Membership lastMembership = visitor.getLastMembership();
        Assertions.assertEquals(membershipList.get(2),lastMembership);
        Assertions.assertTrue(visitor.isValidMembership());
    }
    @Test
    public void InvalidMembershipTest(){
        List<Membership> membershipList = List.of(
                new Membership(LocalDate.of(2022,3,2),7),
                new Membership(LocalDate.of(2023,3,2),7),
                new Membership(LocalDate.of(2021,3,2),7));
        membershipList.forEach(Membership::computeExpirationDate);
        Visitor visitor = new Visitor("CABY","Yohann",1987);
        visitor.setMembershipList(membershipList);
        Membership lastMembership = visitor.getLastMembership();
        Assertions.assertEquals(membershipList.get(1),lastMembership);
        Assertions.assertFalse(visitor.isValidMembership());
    }*/
}
