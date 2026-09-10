package todolist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Todo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String titolo;
    private Boolean completato;

    public Todo() {
    }
    
    public Todo(Long id, String titolo, boolean completato) {
        this.titolo = titolo;
        this.completato = completato;
    }

    public Long getId() {
        return id;
    }
    
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    public Boolean isCompletato() {
        return completato;
    }

    public void setCompletato(boolean completato) {
        this.completato = completato;
    }
}
