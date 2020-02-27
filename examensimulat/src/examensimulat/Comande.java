package examensimulat;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comandes database table.
 * 
 */
@Entity
@Table(name="comandes")
@NamedQuery(name="Comande.findAll", query="SELECT c FROM Comande c")
public class Comande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int comandaid;

	@Column(length=180)
	private String adreça;

	@Column(length=180)
	private String ciutat;

	private int codipostal;

	@Temporal(TemporalType.DATE)
	private Date datacomanda;

	@Temporal(TemporalType.DATE)
	private Date dataenviament;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientid")
	private Client client;

	//bi-directional many-to-one association to DetallComande
	@OneToMany(mappedBy="comande")
	private List<DetallComande> detallComandes;

	public Comande() {
	}

	public int getComandaid() {
		return this.comandaid;
	}

	public void setComandaid(int comandaid) {
		this.comandaid = comandaid;
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

	public Date getDatacomanda() {
		return this.datacomanda;
	}

	public void setDatacomanda(Date datacomanda) {
		this.datacomanda = datacomanda;
	}

	public Date getDataenviament() {
		return this.dataenviament;
	}

	public void setDataenviament(Date dataenviament) {
		this.dataenviament = dataenviament;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<DetallComande> getDetallComandes() {
		return this.detallComandes;
	}

	public void setDetallComandes(List<DetallComande> detallComandes) {
		this.detallComandes = detallComandes;
	}

	public DetallComande addDetallComande(DetallComande detallComande) {
		getDetallComandes().add(detallComande);
		detallComande.setComande(this);

		return detallComande;
	}

	public DetallComande removeDetallComande(DetallComande detallComande) {
		getDetallComandes().remove(detallComande);
		detallComande.setComande(null);

		return detallComande;
	}

}