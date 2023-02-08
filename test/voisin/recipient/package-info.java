package voisin.recipient;

import java.util.function.BooleanSupplier;

public class Recipient {

    private int capacite;
    private int espaceLibre;

    /**
     * Initialise un récipient de quantité quantite et de capacité. <br>
     * Requiert quantite >=0; <= capacite;
     * 
     * @param quantite quantité. Doit être >= 0
     * @param capacite capacité. Doit être >= quantite
     */
    public Recipient(int quantite, int capacite) {
        this.capacite = capacite;
        this.espaceLibre = capacite - quantite;
    }



     /**
     * Nombre d'élement dans le récipient. <br>
     * est >=0; est &lt;< getCapacite().
     * 
     * @return
     */
    public int getQuantite() {
        return capacite - espaceLibre;
    }

    /**
     * Nombre maximal d'élement que peut contenir le récipient. <br>
     * est >= getQuantite().
     * 
     * @return
     */
    public int getCapacite() {
        return capacite;
    }

    public int getEspaceLibre() {
        return espaceLibre;
    }

    public boolean isPlein() {
        return espaceLibre == 0;
    }

    public boolean isVide() {
        return espaceLibre == capacite;
    }

    /**
     * Dansplace un élement du récipient dans autre. <br>
     * Requiert !isVide(); !autre.isPlein() <br>
     * Garantit getQuantite() == old getQuantite() -1; autre.getQuantite() == old
     * autre.getQuantite() + 1
     * 
     * @param autre récipient cible
     */
    public void mettreUnDans(Recipient autre) {
        espaceLibre++;
        autre.espaceLibre--;
    }
/
     * Remplit autre. <br>
     * Requiert getQuantite() >= autre.getEspaceLibre() <br>
     * Garantit autre.isPlein(); getQuantite() == old getQuantite() - old
     * autre.getEspaceLibre();
     * 
     * @param autre
     */

    public void remplir(Recipient autre) {
        espaceLibre += autre.espaceLibre;
        autre.espaceLibre = 0;
    }

    /
     * Vider dans autre <br>
     * Requiert getQuantite() &lt;= autre.getEspaceLibre() <br>
     * Garantit isVide(); autre.getQuantite() == old autre.getQuantite() + old
     * espaceLibre()
     * 
     * @param autre
     */
    public void viderDans(Recipient autre) {
        autre.espaceLibre -= getQuantite();
        espaceLibre = capacite;
    }

    public boolean isInvariantOk() {
        assert getCapacite() == getQuantite() + getEspaceLibre();
        return true;
    }

}