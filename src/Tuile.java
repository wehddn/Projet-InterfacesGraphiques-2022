package src;

import java.util.ArrayList;

public class Tuile {
    private int type; // 4/6
    private char composant; // S/L/W/.
    private ArrayList<Integer> connexions; // static?
    private boolean power;
    private boolean visited;

    public Tuile(String composant, ArrayList<Integer> connexions) {
        this.composant = composant.charAt(0);
        this.connexions = connexions;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public char getComposant() {
        return composant;
    }

    public void setComposant(char composant) {
        this.composant = composant;
    }

    public ArrayList<Integer> getConnexions() {
        return connexions;
    }

    public void setConnexions(ArrayList<Integer> connexions) {
        this.connexions = connexions;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        String result = String.valueOf(composant);
        if (connexions.size() != 0) {
            result += " : ";
            for (Integer connexion : connexions) {
                result += connexion.toString() + " ";
            }
        }
        return result;
    }

    public void turnTuile(int n) {
        for (int i = 0; i < connexions.size(); i++) {
            connexions.set(i, (connexions.get(i) + n) % type);
        }
    }
}
