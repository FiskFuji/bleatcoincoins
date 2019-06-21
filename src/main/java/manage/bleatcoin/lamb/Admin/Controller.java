package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.PatronService;
import manage.bleatcoin.lamb.Admin.entities.Response;
import manage.bleatcoin.lamb.Admin.entities.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api", produces="application/json")
public class Controller {

    @Autowired
    PatronService serv;

    @CrossOrigin
    @PostMapping(value="/create")
    public Object create(@RequestBody List<Patron> p) {
        serv.createPatron(p);
        return new Response(false, "New patron created.");
    }

    @CrossOrigin
    @PostMapping(value="/allPatrons")
    public Collection<Patron> getAll() {
        return serv.getAllPatrons();
    }

    @CrossOrigin
    @GetMapping("/getById/{p-id}")
    public Object getPatronById(@PathVariable(value="p-id") int id) {
        Optional<Patron> patron = serv.findPatronById(id);
        if(!patron.isPresent())
            return new Response(true, "No patron with given ID: " + Integer.toString(id));
        return patron;
    }

    @CrossOrigin
    @PutMapping(value="/update/{p-id}")
    public Object update(@PathVariable(value="p-id") int id, @RequestBody Patron p) {
        p.setId(id);
        Optional<Patron> patron = serv.findPatronById(id);
        if(!patron.isPresent()) {
            return new Response(true, "No patron with given ID: " + Integer.toString(id));
        }
        serv.updatePatron(p);
        return new Response(false, "Patron with ID " + Integer.toString(id) + " record updated.");
    }

    @CrossOrigin
    @DeleteMapping(value="/delete/{p-id}")
    public Object delete(@PathVariable(value="p-id") int id) {
        Optional<Patron> patron = serv.findPatronById(id);
        if(!patron.isPresent()) {
            return new Response(true, "No patron with given ID: " + Integer.toString(id));
        }
        serv.deletePatronById(id);
        return new Response(false, "Patron with ID " + Integer.toString(id) + " record deleted.");
    }
}
