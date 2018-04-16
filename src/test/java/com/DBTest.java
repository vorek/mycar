package com;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myauto.entity.AppUser;
import com.myauto.entity.Car;
import com.myauto.entity.Event;
import com.myauto.enums.EventType;
import com.myauto.enums.FuelType;
import com.myauto.ids.AppUserId;
import com.myauto.ids.CarId;
import com.myauto.ids.EventId;
import com.myauto.repository.CarRepository;
import com.myauto.repository.EventRepository;
import com.myauto.repository.UserRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DBTest extends TestCase {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CarRepository carRepository;
    
    @Autowired
    EventRepository eventRepository;
    
    @Test
    public void testAddingRecord() {
        AppUser user = AppUser.builder()
                .id(AppUserId.fromString("au-1"))
                .name("TestName1")
                .build();
        userRepository.add(user);
        
        Car car = Car.builder()
                .id(CarId.fromString("c-1"))
                .vendor("Toyota")
                .model("bB2")
                .year(2009l)
                .mileage(13400l)
                .fuelType(FuelType.GASOLINE)
                .vinCode("XWEFF231280000095")
                .userId(user.getId())
                .build();
        carRepository.add(car);
        
        Event event = Event.builder()
                .id(EventId.fromString("e-1"))
                .data(LocalDate.now())
                .type(EventType.FUELING)
                .price(1000.00)
                .description("Заправка")
                .mileage(15000l)
                .carId(car.getId())
                .build();
        eventRepository.add(event);

        AppUser user2 = userRepository.get(AppUserId.fromString("au-1"));
        assertEquals(user2.getName(), "TestName1");
        assertEquals(user2.getCars().size(), 1);
        Car car2 = user2.getCars().stream().findFirst().orElse(null);
        assertNotNull(car2);
        assertEquals(car2.getModel(), "bB2");
        Event event2 = car2.getEvents().stream().findFirst().orElse(null);
        assertNotNull(event2);
        assertEquals(event2.getMileage().longValue(), 13400l);
    }
}
