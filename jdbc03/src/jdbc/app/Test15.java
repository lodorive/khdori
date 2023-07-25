package jdbc.app;

import jdbc.dao.ProductDao;

public class Test15 {
	public static void main(String[] args) {
		
		int no = 12;
		
		ProductDao dao = new ProductDao();
		boolean result = dao.delete(no);
		
		if(result) {
			System.out.println("상품 삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 상품 번호");
		}
	}
}
