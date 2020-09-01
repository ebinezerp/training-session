package hibernate.mapppings.tableperhirarchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "electronic")
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
