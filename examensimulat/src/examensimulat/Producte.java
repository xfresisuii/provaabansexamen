package examensimulat;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="productes")
@NamedQuery(name="Producte.findAll", query="SELECT p FROM Producte p")
public class Producte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int productesid;

	@Column(nullable=false, length=50)
	private String categoria;

	@Column(nullable=false, length=50)
	private String nom;

	@Column(nullable=false)
	private int preusunitat;

	@Column(nullable=false)
	private int stock;

	//bi-directional many-to-one association to DetallComande
	@OneToMany(mappedBy="producte")
	private List<DetallComande> detallComandes;

	public Producte() {
	}

	public int getProductesid() {
		return this.productesid;
	}

	public void setProductesid(int productesid) {
		this.productesid = productesid;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPreusunitat() {
		return this.preusunitat;
	}

	public void setPreusunitat(int preusunitat) {
		this.preusunitat = preusunitat;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<DetallComande> getDetallComandes() {
		return this.detallComandes;
	}

	public void setDetallComandes(List<DetallComande> detallComandes) {
		this.detallComandes = detallComandes;
	}

	public DetallComande addDetallComande(DetallComande detallComande) {
		getDetallComandes().add(detallComande);
		detallComande.setProducte(this);

		return detallComande;
	}

	public DetallComande removeDetallComande(DetallComande detallComande) {
		getDetallComandes().remove(detallComande);
		detallComande.setProducte(null);

		return detallComande;
	}

}