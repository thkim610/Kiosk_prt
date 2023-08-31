package library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

	List<Book> books;

	public Library() {
		//인스턴스 생성 시, LinkedList로 생성 (다른 리스트도 상관X)
		this.books = new ArrayList<Book>();
	}

	// 도서 추가
	void addBook(Book book) {
		books.add(book);

	}

	// 도서 검색 (리스트 안에 있는 book 객체의 필드와 비교-> Iterator인터페이스와 hasNext(), next()메서드, while문 활용)
		void searchBook(String title) {
			//Iterator 사용
			Iterator<Book> bookList = books.iterator();

			//찾는 책이 있는지 없는지 판별
			boolean hasBook = false;

			int i = 0;
			while(bookList.hasNext()) { // 해당 콜렉션의 다음요소가 있는지 확인 => 없으면 false 반환
				String selectTitle = books.get(i).getTitle();
				Book book = books.get(i);
				bookList.next(); // 포인터 위치를 다음으로 넘김. (그래야 hasNext()메서드에서 그 다음요소를 확인할 수 있음.
				
				if(selectTitle.equals(title)) {
					System.out.println(book.toString());
					hasBook = true;
				}
		
				i++; //다음 인덱스로 넘어감
			}
				if(!hasBook) {
					System.out.println("찾으시는 도서가 없습니다.");
				}
			
		}
	// 모든 도서목록 출력 (book클래스의 toString메서드와 for-each문 활용)
	void allbookList() {
		System.out.println("현재 도서관에 있는 도서목록입니다.");
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	// 특정년도 이후의 도서목록 출력 (리스트 안에 있는 book 객체의 필드와 비교-> if문과 for-each문, toString 활용)
	void afterYearBookList(int year) {
		System.out.println(year + "년 이후 출판된 도서목록입니다.");
		for (Book book : books) {
			if (book.getPublicationYear() > year) {
				System.out.println(book.toString());
			}
		}
	}
}