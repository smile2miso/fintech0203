package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartAddService;
import vo.ActionForward;
import vo.Dog;

public class DogCartAddAction implements Action
{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		DogCartAddService dogCartAddService = new DogCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Dog cartDog = dogCartAddService.getCartDog(id);
		dogCartAddService.addCart(request, cartDog);
		
		// 강제로 장바구니 리스트로 보냄 > redirect 기능
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}

}
