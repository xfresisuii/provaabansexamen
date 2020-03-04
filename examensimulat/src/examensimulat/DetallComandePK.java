package examensimulat;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detall_comandes database table.
 * 
 */
@Embeddable
public class DetallComandePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int comandaid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int producteid;

	public DetallComandePK() {
	}
	public int getComandaid() {
		return this.comandaid;
	}
	public void setComandaid(int comandaid) {
		this.comandaid = comandaid;
	}
	public int getProducteid() {
		return this.producteid;
	}
	public void setProducteid(int producteid) {
		this.producteid = producteid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallComandePK)) {
			return false;
		}
		DetallComandePK castOther = (DetallComandePK)other;
		return 
			(this.comandaid == castOther.comandaid)
			&& (this.producteid == castOther.producteid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.comandaid;
		hash = hash * prime + this.producteid;
		
		return hash;
	}
}