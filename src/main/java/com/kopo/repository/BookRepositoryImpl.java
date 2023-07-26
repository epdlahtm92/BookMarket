package com.kopo.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.kopo.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	private List<Book> listOfBooks = new ArrayList<Book>();

	public BookRepositoryImpl() {
		Book book1 = new Book("1", "해리포터와 마법사의 돌", "8,100", "img1.jpg");
		book1.setAuthor("J.K.롤링");
		book1.setDescription("해리포터가 어쩌구");
		book1.setPublisher("문학수첩");
		book1.setCategory("소설");
		book1.setUnitsInStock(30);
		book1.setReleaseDate("2019-11-19");
		book1.setCondition("판매 중");
		
		Book book2 = new Book("2", "반지의 제왕", "207,000", "img2.jpg");
		book2.setAuthor("J.R.R.톨킨");
		book2.setDescription("반지의 제왕이 어쩌구.");
		book2.setPublisher("아르테");
		book2.setCategory("소설");
		book2.setUnitsInStock(5);
		book2.setReleaseDate("2023-03-20");
		book2.setCondition("판매중");
		
		Book book3 = new Book("3", "삼국지", "19,800", "img3.jpg");
		book3.setAuthor("나관중");
		book3.setDescription("후한말기에 유비가 어쩌구.");
		book3.setPublisher("코너스톤");
		book3.setCategory("소설");
		book3.setUnitsInStock(0);
		book3.setReleaseDate("2020-03-09");
		book3.setCondition("품절");
		
		Book book4 = new Book("4", "언리얼 엔진 5로 만드는 나만의 3D 영화 세트", "45,000", "img4.jpg");
		book4.setAuthor("헨크 벤터, 빌헬름 옥터롭");
		book4.setDescription("여러 오픈 소스 프로그램을 사용해서 자신만의 영화 세트를 만드는 방법을 알고 싶은 입문자를 대상으로 한 책이다.");
		book4.setPublisher("에이콘출판");
		book4.setCategory("게임개발프로그래밍");
		book4.setUnitsInStock(0);
		book4.setReleaseDate("2023-07-23");
		book4.setCondition("예약 판매");
		
		Book book5 = new Book("5", "누구나 할 수 있는 유니티 2D 게임 제작", "26,100", "img5.jpg");
		book5.setAuthor("STUDIO SHIN");
		book5.setDescription("게임 개발, 유니티, 프로그래밍 모두 처음인 사람을 위한 단 한 권의 책. 중학교 수준의 영어와 수학, 그리고 ‘게임을 좋아하고 게임을 만들고 싶다’는 마음만 있다면 누구나 즐겁게 유니티 사용법을 익혀 2D 게임을 만들 수 있게 집필한 책이다.");
		book5.setPublisher("STUDIO SHIN");
		book5.setCategory("게임개발프로그래밍");
		book5.setUnitsInStock(23);
		book5.setReleaseDate("2022-10-04");
		book5.setCondition("판매 중");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
		listOfBooks.add(book4);
		listOfBooks.add(book5);
	}
	
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return listOfBooks;
	}
	
	@Override
	public List<Book> getBookListByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> booksByCategory = new ArrayList<Book>();
		for (int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if (category.equalsIgnoreCase(book.getCategory())) {
				booksByCategory.add(book);
			}
		}
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		// TODO Auto-generated method stub
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();
		
		Set<String> booksByFilter = filter.keySet();
		if (booksByFilter.contains("publisher")) {
			for(int j = 0; j < filter.get("publisher").size(); j++) {
				String publisherName = filter.get("publisher").get(j);
				for (int i = 0; i < listOfBooks.size(); i++) {
					Book book = listOfBooks.get(i);
					if (publisherName.equalsIgnoreCase(book.getPublisher())) {
						booksByPublisher.add(book);
					}
				}
			}
			if(booksByFilter.contains("category")) {
				for (int i = 0; i < filter.get("category").size(); i++) {
					String category = filter.get("category").get(i);
					List<Book> list = getBookListByCategory(category);
					booksByCategory.addAll(list);
				}
			}
		}
		booksByCategory.retainAll(booksByPublisher);
		
		return booksByCategory;
	}

	@Override
	public Book getBookId(String bookId) {
		// TODO Auto-generated method stub
		Book bookInfo = null;
		for (int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if (book != null && book.getBookId() != null && book.getBookId().equals(bookId)) {
				bookInfo = book;
				break;
			}
		}
		if (bookInfo == null) {
			throw new IllegalArgumentException("도서의 ID를 찾을 수가 없습니다. : " + bookId);
		} 
		
		return bookInfo;
	}

	@Override
	public void setNewBook(Book book) {
		// TODO Auto-generated method stub
		listOfBooks.add(book);
		
	}
}
