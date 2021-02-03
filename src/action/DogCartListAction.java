package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartListService;
import vo.ActionForward;
import vo.Cart;

public class DogCartListAction implements Action
{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		DogCartListService dogCartListService = new DogCartListService();
		ArrayList<Cart> cartList = dogCartListService.getCartList(request);
		
		//장바구니의 담겨진 총 금액 계산
		int totalMoney = 0;
		int money = 0;
		
		for(int i=0; i <cartList.size(); i++)
		{
			money = cartList.get(i).getPrice() * cartList.get(i).getQty();
			totalMoney += money;
		}
		
		//request scope(영역)에 합계금액과 장바구니 리스트 정보를 
		//속성으로 지정하여 응답처리전까지 유효
		//scope ?
		//page > request > session > application
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("dogCartList.jsp", true);
		return forward;
	}
	
}
