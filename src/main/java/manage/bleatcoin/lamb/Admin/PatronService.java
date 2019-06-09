package manage.bleatcoin.lamb.Admin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import manage.bleatcoin.lamb.Admin.entities.Patron;

public interface PatronService {

	public void createPatron(List<Patron> pats);

    public Collection<Patron> getAllPatrons();
    
	public Optional<Patron> findPatronById(int id);

	public void deletePatronById(int id);

	public void updatePatron(Patron p);

	public void deleteAllPatrons();
}