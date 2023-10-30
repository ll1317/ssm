package com.pojo;

public class BookBean {
	
	private String BookId;
	private String ISBN;
	private String BookName;
	private String Author;
	private Double Price;
	private Integer Num;
    private Integer Number;
    private String ShoppingId;
    
    
	

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Integer getNum() {
		return Num;
	}

	public void setNum(Integer num) {
		Num = num;
	}

	public Integer getNumber() {
		return Number;
	}

	public void setNumber(Integer number) {
		Number = number;
	}

	public String getShoppingId() {
		return ShoppingId;
	}

	public void setShoppingId(String shoppingId) {
		this.ShoppingId = shoppingId;
	}
}
