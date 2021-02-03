package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DogDAO;
import vo.Dog;

public class DogRegistService 
{
	public boolean registDog(Dog dog)
	{
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con= getConnection();
		dogDAO.setConnection(con);
		boolean isResistSuccess = false;
		int insertCount = dogDAO.insertDog(dog);
		
		if(insertCount>0)
		{
			commit(con);
			isResistSuccess=true;
		}
		else
		{
			rollback(con);
		}
		
		close(con);
		
		return isResistSuccess;
	}
}
