package cpnv.jav1.lima;

public class Article
{
	private String _name;
	private int _number;
	private String _responsible;
	private String _supplier;
	private Double _price;
	private Double _vat;
	
	final static String DEFAULT_STRING = "A définir";
	
	
	
	public Article(String name, int number, String responsible, String supplier, Double price, Double vat)
	{
		this.setName(name);
		this.setNumber(number);
		this.setResponsible(responsible);
		this.setSupplier(supplier);
		this.setPrice(price);
		this.setVat(vat);
	}
	public Article() {
		this(DEFAULT_STRING, 0, DEFAULT_STRING, DEFAULT_STRING, 0.0, 0.0);
	}
	public Article(Article article) {
		this(article.getName(), (article.getNumber()+1), article.getResponsible(), article.getSupplier(), article.getPrice(), article.getVat());
	}
	
	
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = (name.length() < 3 ? DEFAULT_STRING : name);
	}
	
	public int getNumber() {
		return _number;
	}
	public void setNumber(int articeNo) {
		_number = (articeNo < 0 ? 0 : articeNo);
	}
	
	public String getResponsible() {
		return _responsible;
	}
	public void setResponsible(String responsible) {
		_responsible = (responsible.length() < 3 ? DEFAULT_STRING : responsible);
	}
	
	public String getSupplier() {
		return _supplier;
	}
	public void setSupplier(String supplier) {
		_supplier = (supplier.length() < 3 ? DEFAULT_STRING : supplier);
	}
	
	public Double getPrice() {
		return _price;
	}
	public void setPrice(Double price) {
		_price = (price < 0 ? 0 : price);
	}
	
	public Double getVat() {
		return _vat;
	}
	public void setVat(Double vat) {
		_vat = (vat < 0 ? 0 : vat);
	}
	
	
	@Override
	public String toString() {
		return this.getName() +'-'+ this.getNumber() +'-'+ this.getResponsible() +'-' + this.getSupplier() +'-'+ this.getPrice() +'-'+ this.getVat();
	}
	public String dump() { return this.toString(); }
	
}
