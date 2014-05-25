package cpnv.jav1.lima;

public class Gear extends Article{

	// Initialization variable size
	private String _size;

	// Constructor
	public Gear(){
		super();
		_size = "Undefined";
	}
	public Gear(String name, String number, String supplier, double price, double VAT, int stock, boolean obs, String size) {
		super(name, number, supplier, price, VAT, stock, obs);
		if ((size.length() > 3) || (size.length() < 1))
			_size = "Undefined";
		else
			_size = size;
	}
	//Setter
	public String getSize(){
		return this._size;
	}
	public void setSize(String size) {
		if ((size.length() > 3) || (size.length() < 1))
			_size = "Undefined";
		else
			_size = size;
	}

	// Methodes
	public String dump() {
		return super.dump()+", size : "+_size;
	}
	
	public int compareTo (Gear other) {
		return 0;
	}

}