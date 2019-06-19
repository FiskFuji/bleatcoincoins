package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.Response;
import manage.bleatcoin.lamb.Admin.entities.Patron;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatronApplicationTests {

    @Autowired
    Controller controller;

    @MockBean
    IPatronRepository patronRepo;

    private Patron p1 = new Patron();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getAllPatronsInDb() {
        p1.setId(1);
        p1.setUsername("abc");
        p1.setCoins(10);
        when(patronRepo.findAll()).thenReturn(new ArrayList<>(Arrays.asList(p1)));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(p1)), controller.getAll());
    }

    @Test
    public void getPatronByIdWhenNullPatronInDb() {
        p1.setId(1);
        p1.setUsername("abc");
        p1.setCoins(10);
        int TEST_ID = 0;
        when(patronRepo.findById(TEST_ID)).thenReturn(Optional.empty());
        Assert.assertEquals(new Response(true, "No patron with given ID: " + Integer.toString(TEST_ID)), controller.getPatronById(TEST_ID));
    }

    @Test
    public void getPatronByIdWhenPatronInDb() {
        p1.setId(1);
        p1.setUsername("abc");
        p1.setCoins(10);
        int TEST_ID = 1;
        when(patronRepo.findById(TEST_ID)).thenReturn(Optional.of(p1));
        Assert.assertEquals(p1, controller.getPatronById(TEST_ID));
    }
}
