package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.MultipartResponse;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.PrintWriter;

import svc.DogRegistService;
import vo.ActionForward;
import vo.Dog;

public class DogRegistAction implements Action
{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		DogRegistService dogRegistService = new DogRegistService();
		
		// 파일 업로드 될 서버상의 물리적인 경로
		String realFolder = "D:\\jspStudy\\DogShopping\\WebContent\\resources\\images";
		//String saveFolder = "/images";
		String encType = "utf-8";
		int maxSize = 5*1024*1024;
		
		//ServletContext context = request.getServletContext();
		//realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest
								(request,
								realFolder,
								maxSize,
								encType,
								new DefaultFileRenamePolicy()
								);
		
		String image = multi.getFilesystemName("image");
		
		Dog dog = new Dog(
				0, 
				multi.getParameter("kind"),
				Integer.parseInt(multi.getParameter("price")),
				image,
				multi.getParameter("country"),
				Integer.parseInt(multi.getParameter("height")),
				Integer.parseInt(multi.getParameter("weight")),
				multi.getParameter("content"),
				0
				);
		
		boolean isRegistSuccess = dogRegistService.registDog(dog);
		ActionForward forward = null;
		
		if(isRegistSuccess)
		{
			forward = new ActionForward("dogList.dog", true);
		}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
