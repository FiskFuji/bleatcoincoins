package manage.bleatcoin.lamb.Admin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import manage.bleatcoin.lamb.Admin.entities.Patron;
import manage.bleatcoin.lamb.Admin.IPatronRepository;
import manage.bleatcoin.lamb.Admin.PatronService;
 
@Service
public class PatronServImpl implements PatronService {

    // DAO Repository use Mongodb-Repository to perform db operations
    @Autowired
    IPatronRepository patronRepo;

    @Override
    public void createPatron(List<Patron> pats) {
        patronRepo.saveAll(pats);
    }

    @Override
    public Collection<Patron> getAllPatrons() {
        return patronRepo.findAll();
    }

    @Override
    public Optional<Patron> findPatronById(int id) {
        return patronRepo.findById(id);
    }

    @Override
    public void deletePatronById(int id) {
        patronRepo.deleteById(id);
    }

    @Override
    public void updatePatron(Patron p) {
        patronRepo.save(p);
    }

    @Override
    public void deleteAllPatrons() {
        patronRepo.deleteAll();
    }
}