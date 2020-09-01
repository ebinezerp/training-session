package hibernate.mapppings.tablepersubclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ElectronicsProduct extends Product {

	private Float ramSize;
	private Float internalMemorySize;

	public ElectronicsProduct() {
		super();
	}

	public ElectronicsProduct(Float ramSize, Float internalMemorySize) {
		super();
		this.ramSize = ramSize;
		this.internalMemorySize = internalMemorySize;
	}

	public ElectronicsProduct(Integer id, String name, Float price, Float ramSize, Float internalMemorySize) {
		super(id, name, price);
		this.ramSize = ramSize;
		this.internalMemorySize = internalMemorySize;
	}

	public ElectronicsProduct(String name, Float price, Float ramSize, Float internalMemorySize) {
		super(name, price);
		this.ramSize = ramSize;
		this.internalMemorySize = internalMemorySize;
	}

	public Float getRamSize() {
		return ramSize;
	}

	public void setRamSize(Float ramSize) {
		this.ramSize = ramSize;
	}

	public Float getInternalMemorySize() {
		return internalMemorySize;
	}

	public void setInternalMemorySize(Float internalMemorySize) {
		this.internalMemorySize = internalMemorySize;
	}

}
