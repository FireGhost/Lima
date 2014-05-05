package cpnv.jav1.lima;

public class Gear extends Article
{
	private String _size;
	
	
	final static String DEFAULT_SIZE = "U";
	
	
	public Gear(String name, int articleNo, String responsible, String supplier, Double price, Double vat, String size)
	{
		super(name, articleNo, responsible, supplier, price, vat);
		this.setSize(size);
	}
	public Gear() {
		super();
		this.setSize(DEFAULT_SIZE);
	}
	public Gear(Gear gear) {
		super(gear);
		this.setSize( gear.getSize() );
	}
	
	
	
	public String getSize() {
		return _size;
	}
	public void setSize(String size) {
		_size = (size.length() < 1 || size.length() > 3 ? Gear.DEFAULT_SIZE : size);
	}
	
	
	@Override
	public String toString() {
		return this.getName() +'-'+ this.getNumber() +'-'+ this.getResponsible() +'-' + this.getSupplier() +'-'+ this.getPrice() +'-'+ this.getVat() +'-'+ this.getSize();
	}
	public String dump() { return this.toString(); }
	

}
