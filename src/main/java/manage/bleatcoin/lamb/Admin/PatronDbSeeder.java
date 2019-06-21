package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PatronDbSeeder implements CommandLineRunner {

    @Autowired
    PatronService serv;

    @Override
    public void run(String... args) throws Exception {
        // --- DB Seeding complete. Do nothing ---
    }
}
