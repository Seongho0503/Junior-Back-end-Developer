package hello.core.order;

public interface OrderService {
	// �ֹ����� -> ���� order ��� ��ȯ
	Order createOrder(Long memberId, String itemName, int itemPrice);
}
