package hello.core.order;

public interface OderService {
	// 주문생성 -> 최종 order 결과 반환
	Order createOrder(Long memberId, String itemName, int itemPrice);
}
