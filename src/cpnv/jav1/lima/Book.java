package cpnv.jav1.lima;

public class Book extends Article
{
	private String _isbn;
	
	
	public Book(String name, int articleNo, String responsible, String supplier, Double price, Double vat, String isbn)
	{
		super(name, articleNo, responsible, supplier, price, vat);
		this.setIsbn(isbn);
	}
	public Book() {
		super();
		this.setIsbn(Article.DEFAULT_STRING);
	}
	public Book(Book book) {
		this(book.getName(), (book.getNumber()+1), book.getResponsible(), book.getSupplier(), book.getPrice(), book.getVat(), book.getIsbn());
	}
	
	
	public String getIsbn() {
		return _isbn;
	}
	public void setIsbn(String isbn) {
		_isbn = (isbn.length() < 6 ? Article.DEFAULT_STRING : isbn);
	}
	
	
	@Override
	public String toString() {
		return this.getName() +'-'+ this.getNumber() +'-'+ this.getResponsible() +'-' + this.getSupplier() +'-'+ this.getPrice() +'-'+ this.getVat() +'-'+ this.getIsbn();
	}
	public String dump() { return this.toString(); }
	
	
}
