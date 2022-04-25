package hello.core.order;

// 주분 다 끝날을 때 만들어지는 객체
public class Order {
	
	private Long memberId;
	private String itemName;
	//원가
	private int itemPrice; 
	// 할인금액
	private int discountPrice;
	
	public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
		super();
		this.memberId = memberId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}
	
	// 계산 로직 (할인된 계산된 금액 결과 = 최증 금액)
	public int calculatePrice() {
		return itemPrice - discountPrice;
	}
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	
//  System.out.println(order) 객체 이름 출력하면 tostring 호출
	@Override
	public String toString() {
		return "Order [memberId=" + memberId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", discountPrice=" + discountPrice + "]";
	}

	
	
}
