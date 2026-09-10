package todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;*/

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    /* private List<Todo> listaTodo = new ArrayList<>(); */

    /*
     * public TodoController() {
     * listaTodo.add(new Todo(1L, "Comprare patatine", false));
     * listaTodo.add(new Todo(2L, "portare cane veterinario", true));
     * listaTodo.add(new Todo(3L, "studiare react.js", false));
     * }
     */

    @GetMapping("/todos")
    public List<Todo> getTutti() {
        return todoRepository.findAll();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getUno(@PathVariable Long id) {
        Optional<Todo> risultato = todoRepository.findById(id);
        if (risultato.isPresent()) {
            return ResponseEntity.ok(risultato.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/todos")
    public Todo creaTodo(@RequestBody Todo nuovoTodo) {
        return todoRepository.save(nuovoTodo);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> aggiorna(@PathVariable Long id, @RequestBody Todo datiAggiornati) {
        Optional<Todo> risultato = todoRepository.findById(id);
        if (risultato.isPresent()) {
            Todo esistente = risultato.get();
            esistente.setCompletato(datiAggiornati.isCompletato());
            todoRepository.save(esistente);
            return ResponseEntity.ok(esistente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> elimina(@PathVariable Long id) {        
        if (todoRepository.existsById(id)) {
           todoRepository.deleteById(id);
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
