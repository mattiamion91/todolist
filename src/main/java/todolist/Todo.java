package todolist;

public class Todo {

    private Long id;
    private String titolo;
    private Boolean completato;
    
    public Todo(Long id, String titolo, boolean completato) {
        this.id = id;
        this.titolo = titolo;
        this.completato = completato;
    }

    public Long getId() {
        return id;
    }
    
    public String getTitolo() {
        return titolo;
    }
    
    public Boolean isCompletato() {
        return completato;
    }

    public void setCompletato(boolean completato) {
        this.completato = completato;
    }
}
