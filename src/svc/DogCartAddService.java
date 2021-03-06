package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DogDAO;
import vo.Cart;
import vo.Dog;

public class DogCartAddService 
{
	public Dog getCartDog(int id)
	{
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		Dog dog = dogDAO.selectDog(id);
		close(con);
		return dog;
	}
	
	public void addCart(HttpServletRequest request, Dog cartDog)
	{
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null)
		{
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true; // 
		
		for(int i=0; i <cartList.size(); i++)
		{
			if(cartDog.getKind().equals(cartList.get(i).getKind()))
			{
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty());
				break;
			}
		}
		
		if(isNewCart) //새 장바구니일 경우
		{
			Cart cart = new Cart(); // 장바구니 객체 생성하여 담기
			cart.setImage(cartDog.getImage());
			cart.setKind(cartDog.getKind());
			cart.setPrice(cartDog.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
	}
}
