package hibernate.mapppings.tablepersubclass;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
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

	public String getTypeOfCloth() {
		return typeOfCloth;
	}

	public void setTypeOfCloth(String typeOfCloth) {
		this.typeOfCloth = typeOfCloth;
	}

	public Float getUnitSize() {
		return unitSize;
	}

	public void setUnitSize(Float unitSize) {
		this.unitSize = unitSize;
	}

}
