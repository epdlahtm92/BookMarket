package com.kopo.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kopo.domain.Book;

public interface BookRepository {
	
	//��� ���� ��ȸ
	List<Book> getAllBookList();
	
	//�Ű������� ������ �з��� ������ ��ȸ
	List<Book> getBookListByCategory(String category);
	
	//�з��� ���ǻ簡 ������ ������ ��ȯ
	// ex) url = localhost:8082/controller/books/filter/bookFilter;publisher=���̹�;category=IT������
	// �� ���ǿ� �����ϴ� ��ϸ� ��ȯ�ǵ��� ����, ���̹�, IT������ value���� ���� ����
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	
	Book getBookId(String bookId);
	
	void setNewBook(Book book);
}
