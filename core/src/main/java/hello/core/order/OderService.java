package hello.core.order;

public interface OderService {
	// �ֹ����� -> ���� order ��� ��ȯ
	Order createOrder(Long memberId, String itemName, int itemPrice);
}
