package todolist;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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
    public Todo getUno (@PathVariable Long id) {
        for (Todo t : listaTodo) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @PutMapping("/todos/{id}")
    public Todo aggiorna(@PathVariable Long id, @RequestBody Todo datiAggiornati) {
        Todo esistente = getUno(id);
        if(esistente != null) {
            esistente.setCompletato(datiAggiornati.isCompletato());
        }
        return esistente;
    }

    @DeleteMapping("/todos/{id}")
    public void elimina(@PathVariable Long id) {
      Todo daRimuovere = getUno(id);
      if(daRimuovere != null) {
        listaTodo.remove(daRimuovere);
      }
    } 

}
