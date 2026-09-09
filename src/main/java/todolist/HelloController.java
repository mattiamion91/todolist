package todolist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController 

public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Ciao! il mio primo endpoint funziona";
    }

    @GetMapping("/saluta/{nome}")
    public String saluta(@PathVariable String nome) {
        return "Ciao " + nome + "! Benvenuto in SpringBoot.";
    }    

}
