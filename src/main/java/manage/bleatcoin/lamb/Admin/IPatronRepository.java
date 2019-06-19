package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.Patron;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatronRepository extends MongoRepository<Patron, Integer> { }
