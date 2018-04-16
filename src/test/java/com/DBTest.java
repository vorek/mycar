package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myauto.entity.AppUser;
import com.myauto.ids.AppUserId;
import com.myauto.repository.UserRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DBTest extends TestCase {
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    public void testAddingUser() {
        AppUser user = AppUser.builder()
                .id(AppUserId.fromString("au-1"))
                .name("TestName1")
                .build();
        userRepository.add(user);
        AppUser user2 = userRepository.get(AppUserId.fromString("au-1"));
        assertTrue(user2.getName().equals("TestName1"));
    }
}
