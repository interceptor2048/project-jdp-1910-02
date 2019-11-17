package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.GroupService;
import org.h2.tools.Server;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTestSuite {

    @Autowired
    private GroupService groupService;

    @BeforeClass
    public static void initTest() throws SQLException {
        Server webServer = Server.createWebServer("-web",
                "-webAllowOthers", "-webPort", "8082");
        webServer.start();
    }

    @Test
    public void testSaveToDb() {
        //Given
        Group agd = new Group("agd", "grupa ze sprzętami agd");
        Group rtv = new Group("rtv", "grupa ze sprzętami rtv");
        groupService.saveGroup(agd);
        groupService.saveGroup(rtv);
        //When
        int amountOfGroups = groupService.getAllGroups().size();
        long agdId = agd.getId();
        long rtvId = rtv.getId();
        //Then
        System.out.println("ID grupy agd : " + agdId);
        System.out.println("ID grupy rtv : " + rtvId);
        Assert.assertEquals(2, amountOfGroups);
    }

    @Test
    public void testGetGroup() {
        //Given
        Group agd = new Group("agd", "grupa ze sprzętami agd");
        Group rtv = new Group("rtv", "grupa ze sprzętami rtv");
        groupService.saveGroup(agd);
        groupService.saveGroup(rtv);
        //When
        String adgDescription = groupService.getGroup(agd.getId()).get().getDescription();
        //Then
        Assert.assertEquals("grupa ze sprzętami agd", adgDescription);
    }

    @Test
    public void testGetAllGroups() {
        //Given
        Group agd = new Group("agd", "grupa ze sprzętami agd");
        Group rtv = new Group("rtv", "grupa ze sprzętami rtv");
        Group computers = new Group("computer", "grupa z komputerami");
        groupService.saveGroup(agd);
        groupService.saveGroup(rtv);
        groupService.saveGroup(computers);
        //When
        List<Group> allGroups = groupService.getAllGroups();
        //Then
        Assert.assertEquals(3, allGroups.size());
    }
}
