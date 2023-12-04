package es.iescarrillo.ejemplobbddfirebasecag.models;

import java.util.List;

public class Superhero {

    private long id;

    private String name;

    private List<String> powers;

    private boolean active;


    public Superhero(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", powers=" + powers +
                ", active=" + active +
                '}';
    }
}
