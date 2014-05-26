package cpnv.jav1.lima;

public class Size {
	
	int _sizeNo;
	String _size;
	
	
	public Size(String size)
	{
		this.setSize(size);
		
		if (size.equals("XS")) {
			this.setSizeNo(1);
		}
		else if (size.equals("S")) {
			this.setSizeNo(2);
		}
		else if (size.equals("M")) {
			this.setSizeNo(3);
		}
		else if (size.equals("L")) {
			this.setSizeNo(4);
		}
		else if (size.equals("XL")) {
			this.setSizeNo(5);
		}
		else if (size.equals("XXL")) {
			this.setSizeNo(6);
		}
		else {
			this.setSizeNo(0);
		}
	}
	
	
	
	
	public int compareTo(Size other)
	{
		if (this.getSizeNo() > other.getSizeNo())
			return 1;
		else if (this.getSizeNo() < other.getSizeNo())
			return -1;
		else
			return 0;
	}
	
	
	
	public int getSizeNo() {
		return _sizeNo;
	}
	public void setSizeNo(int _sizeNo) {
		this._sizeNo = _sizeNo;
	}
	
	public String getSize() {
		return _size;
	}
	public void setSize(String _size) {
		this._size = _size;
	}

}
