package hibernate.mapppings.tableperhirarchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "cloth")
public class Cloth extends Product {

	private String typeOfCloth;
	private Float unitSize;

	public Cloth() {
		super();
	}

	public Cloth(String typeOfCloth, Float unitSize) {
		super();
		this.typeOfCloth = typeOfCloth;
		this.unitSize = unitSize;
	}

	public Cloth(Integer id, String name, Float price, String typeOfCloth, Float unitSize) {
		super(id, name, price);
		this.typeOfCloth = typeOfCloth;
		this.unitSize = unitSize;
	}

	public Cloth(String name, Float price, String typeOfCloth, Float unitSize) {
		super(name, price);
		this.typeOfCloth = typeOfCloth;
		this.unitSize = unitSize;
	}

}
