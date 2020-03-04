package examensimulat;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int clientid;

	@Column(nullable=false, length=100)
	private String adreça;

	@Column(nullable=false, length=100)
	private String ciutat;

	@Column(nullable=false)
	private int codipostal;

	@Column(nullable=false, length=100)
	private String dni;

	@Column(nullable=false, length=100)
	private String nom;

	@Column(nullable=false)
	private int telefon;

	//bi-directional many-to-one association to Comande
	@OneToMany(mappedBy="client")
	private List<Comande> comandes;

	public Client() {
	}

	public int getClientid() {
		return this.clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getAdreça() {
		return this.adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public String getCiutat() {
		return this.ciutat;
	}

	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

	public int getCodipostal() {
		return this.codipostal;
	}

	public void setCodipostal(int codipostal) {
		this.codipostal = codipostal;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public List<Comande> getComandes() {
		return this.comandes;
	}

	public void setComandes(List<Comande> comandes) {
		this.comandes = comandes;
	}

	public Comande addComande(Comande comande) {
		getComandes().add(comande);
		comande.setClient(this);

		return comande;
	}

	public Comande removeComande(Comande comande) {
		getComandes().remove(comande);
		comande.setClient(null);

		return comande;
	}

}