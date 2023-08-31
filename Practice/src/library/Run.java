package library;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// 예시 도서 리스트 추가
		Book b1 = new Book("어린왕자", "생텍쥐페리", 1990);
		Book b2 = new Book("장발장", "빅토르위고", 2000);
		Book b3 = new Book("코딩의역사", "김완", 2020);
		Book b4 = new Book("자바의기초", "이로운", 2021);
		Book b5 = new Book("알고리즘", "김태호", 2023);

		Library lib = new Library();

		lib.addBook(b1);
		lib.addBook(b2);
		lib.addBook(b3);
		lib.addBook(b4);
		lib.addBook(b5);

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("무엇을 도와드릴까요? (1.도서 등록 2.도서 검색 3.도서 목록 4.특정년도 이후 도서검색 0.종료)");
			int num = sc.nextInt();

			if (num == 0) {
				System.out.println("이용해주셔서 감사합니다. :)");
				break;
			}

			// 1.도서 등록
			if (num == 1) {
				System.out.println("도서 등록을 위해서 다음 정보를 입력해주세요.");
				System.out.print("제목: ");
				String title = sc.next();

				System.out.print("작가: ");
				String author = sc.next();

				System.out.print("출판년도: ");
				int year = sc.nextInt();

				Book book = new Book(title, author, year);
				lib.addBook(book);
				System.out.println("도서 등록이 완료되었습니다.");

				// 2.도서 검색
			} else if (num == 2) {
				System.out.println("검색할 도서명을 입력해주세요.");
				String title = sc.next();

				lib.searchBook(title);

				// 3.도서 목록
			} else if (num == 3) {
				lib.allbookList();

				// 4.특정년도 이후의 도서목록
			} else if (num == 4) {
				System.out.println("년도를 입력해주세요.");
				int afterYear = sc.nextInt();
				lib.afterYearBookList(afterYear);
			}

		}
		sc.close();
	}

}