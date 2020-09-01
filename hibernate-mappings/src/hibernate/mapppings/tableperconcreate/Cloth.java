package hibernate.mapppings.tableperconcreate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "prod_id")))
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
