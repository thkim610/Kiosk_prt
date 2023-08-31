package library;

public class Book {

	private String title; // 제목
	private String author; // 작가
	private int publicationYear; // 출판년도

	public Book(String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	// 도서 정보 출력
	@Override
	public String toString() {
		return "[제목: " + title + ", 작가: " + author + ", 출판년도: " + publicationYear + "년]";
	}

//각 필드의 getter 메서드
	// 제목
	public String getTitle() {
		return title;
	}

	// 작가
	public String getAuthor() {
		return author;
	}

	// 출판년도
	public int getPublicationYear() {
		return publicationYear;
	}

}