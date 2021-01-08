package jpsave.airbnb.utilisateurs;

public class Personne {

    private String prenom;
    private String nom;
    private int age;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public void afficher() {
        System.out.print(prenom + " " + nom + " (" + age + " ans)");
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Personne) {
            Personne p = (Personne)anObject;
            return prenom.equals(p.prenom) && nom.equals(p.nom);
        }
        return false;
    }
}
