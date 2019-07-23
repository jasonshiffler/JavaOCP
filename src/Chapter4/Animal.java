package Chapter4;

import java.util.Objects;

public class Animal {


    // == Instance Variables

    private int weight;
    private String species;
    private String name;
    boolean canFly;
    boolean canSwim;

    Animal(int weight, String species, String name) {

        setWeight(weight);
        setSpecies(species);
        setName(name);

    }



    // == Methods

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    @Override
    public String toString(){
        return getName() + " " + getSpecies() +" " + getWeight();
    }


    @Override
    public int hashCode(){
        return Objects.hash(getName(),getSpecies(), getWeight());
    }


}
