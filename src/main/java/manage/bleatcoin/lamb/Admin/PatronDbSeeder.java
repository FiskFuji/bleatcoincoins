package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.Patron;
import manage.bleatcoin.lamb.Admin.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class PatronDbSeeder implements CommandLineRunner {

    @Autowired
    PatronService serv;

    @Override
    public void run(String... args) throws Exception {
        Patron testPatron1 = new Patron();
        testPatron1.setUsername("Fisk");
        testPatron1.setCoins(10);
        Patron testPatron2 = new Patron();
        testPatron2.setUsername("Lusty Lamb");
        testPatron2.setCoins(121);
        Patron testPatron3 = new Patron();
        testPatron3.setUsername("Leon962");
        testPatron3.setCoins(33);

        // Seed DB.
        serv.deleteAllPatrons();
        List<Patron> patrons = Arrays.asList(testPatron1, testPatron2, testPatron3);
        serv.createPatron(patrons);
    }
}
