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
	
	/**
	 * Compare this gear object to another.
	 * The comparison order is: 
	 *   - Alphabetically on the name
	 *   - On the size (XS,S,M,L,XL,XXL)
	 *   - Alphabetically on the supplier name
	 * @param other
	 * The other Gear to which we compare this object
	 * @return
	 * 1 if 'this' is greater than 'other'
	 * 0 if 'this' is equal to 'other'
	 * -1 if 'this' is smaller than 'other'
	 */
	public int compareTo (Gear other) {
		
		/**
		 * Compare alphabetically
		 */
		int otherLength = other.getName().length();
		for (int i = 0; i < otherLength; i++) {
			try {
				if (this.getName().charAt(i) > other.getName().charAt(i)) {
					return 1;
				}
				else if (other.getName().charAt(i) > this.getName().charAt(i)) {
					return -1;
				}
			}
			catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		
		/**
		 * Compare with sizes
		 */
		Size otherSize = new Size(other.getSize());
		Size thisSize = new Size(this.getSize());
		
		switch (thisSize.compareTo(otherSize)) 
		{
		case 1:
			return 1;
			
		case -1:
			return -1;
			
		case 0:
			break;
		}
		
		
		/**
		 * Compare with supplier name
		 */
		int otherSupplierLength = other.getSupplier().length();
		for (int i = 0; i < otherSupplierLength; i++) {
			try {
				if (this.getSupplier().charAt(i) > other.getSupplier().charAt(i))
					return 1;
				else if (other.getSupplier().charAt(i) > this.getSupplier().charAt(i))
					return -1;
			}
			catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		
		
		// At end, if no return before, automatically return 0 (equals)
		return 0;
		
	}

}