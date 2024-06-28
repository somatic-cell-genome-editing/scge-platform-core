package edu.mcw.scge.platform.dao.implementation;

import edu.mcw.scge.platform.datamodel.Person;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

public class PersonDaoTest {
    @Test
    public void getAllActiveMembersTest() throws Exception {
        PersonDao personDao=new PersonDao();
        List<Person> personList=personDao.getAllActiveMembers();
        Assert.assertFalse(personList.isEmpty());
    }

}
