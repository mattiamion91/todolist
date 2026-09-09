package todolist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

}
