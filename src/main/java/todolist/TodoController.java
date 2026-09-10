package todolist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;

@RestController
public class TodoController {

    private List<Todo> listaTodo = new ArrayList<>();

    public TodoController() {
        listaTodo.add(new Todo(1L, "Comprare patatine", false));
        listaTodo.add(new Todo(2L, "portare cane veterinario", true));
        listaTodo.add(new Todo(3L, "studiare react.js", false));
    }

    @GetMapping("/todos")
    public List<Todo> getTutti() {
        return listaTodo;
    }

    @PostMapping("/todos")
    public Todo creaTodo(@RequestBody Todo nuovoTodo) {
        listaTodo.add(nuovoTodo);
        return nuovoTodo;
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getUno(@PathVariable Long id) {
        for (Todo t : listaTodo) {
            if (t.getId().equals(id)) {
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> aggiorna(@PathVariable Long id, @RequestBody Todo datiAggiornati) {
        ResponseEntity<Todo> risposta = getUno(id);
        if (risposta.getStatusCode().is2xxSuccessful()) {
            Todo esistente = risposta.getBody();
            esistente.setCompletato(datiAggiornati.isCompletato());
            return ResponseEntity.ok(esistente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> elimina(@PathVariable Long id) {
        ResponseEntity<Todo> risposta = getUno(id);
        if (risposta.getStatusCode().is2xxSuccessful()) {
            listaTodo.remove(risposta.getBody());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
