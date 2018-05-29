package adventure_game;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



/**
 *
 * @author dmorax
 */
public class ControleurJeux implements Initializable {
    
    private Jeux jeu;
    
    private static final String csvSalle = "texte/salle.csv";
    private static final String csvObjet = "texte/item.csv";
    
    Zone z = new Zone();
    
    PersonnagePrincipal p = new PersonnagePrincipal(100, 10,0, Zone.obtenirSalleCommencement());
    
    @FXML
    private TextArea jeux;
    
    @FXML
    private TextArea actions;
    
    @FXML
    private ListView inventaire;
    
    @FXML 
    private ListView caracteristiques;
    
    @FXML
    private TextField entrerCommande;
    
    @FXML
    private TextArea localisation;

    /**
     *
     * @param jeu
     */
    public ControleurJeux(Jeux jeu) {
        this.jeu = jeu; 
    }
    
    /**
     *
     * @param texte
     */
    public void setLocation(String texte) {
        
    }
    
    /**
     *
     * @param e
     * @throws InterruptedException
     */
    public void saisieCommande(KeyEvent e) throws InterruptedException {
        if(KeyCode.ENTER == e.getCode()){
            String affichage;
            
            affichage = jeu.traiterCommande(entrerCommande.getText());
            if (p.pointsVie < 0){
                TimeUnit.SECONDS.sleep(1);
                System.exit(0);
            }
            jeux.appendText(affichage);
            entrerCommande.clear();
            affichageInventaire();
            affichageLocalisation();
            affichageCaracteristiques();
        }
       
    }

    /**
     *
     */
    public void affichageInventaire(){
        ObservableList<String> objets = FXCollections.observableArrayList();
        for(Objet o : p.obtenirInventaire().obtenirListeObjets().values()){
            objets.add(o.obtenirNom() + " (" + ((o.obtenirMunitions() == null) ? "" : + o.obtenirMunitions()) + 
                                          ((o.obtenirDureeVie() == null) ? "" : o.obtenirDureeVie()) + ")");
        }
        inventaire.setItems(objets);
    }
    
    /**
     *
     */
    public void affichageCaracteristiques(){
        ObservableList<String> carac = FXCollections.observableArrayList();
        carac.add("HP: " + p.obtenirPointsVie());
        carac.add("Degats: " + p.obtenirDegats());
        carac.add("Armure: " + p.obtenirArmure());
        caracteristiques.setItems(carac);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       jeu.setP(p);
       jeu.initJeux(csvSalle,csvObjet,z);
       Zone.obtenirSalleCommencement().ajoutVoisins(1, Direction.EST);
       jeux.setWrapText(true);
       jeux.appendText(Jeux.LireFichier("texte/debut.txt"));
       jeux.setEditable(false);
       affichageLocalisation();
       affichageInventaire();
       affichageActions();
       affichageCaracteristiques();
    }
    
    /**
     *
     */
    public void affichageLocalisation(){
        localisation.setEditable(false);
        localisation.setText(p.salle.decrire());
    }
    
    /**
     *
     */
    public void affichageActions(){
        actions.setEditable(false);
        actions.setText(Jeux.LireFichier("texte/commandes.txt"));
    }
}
