package Urbex;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Database prueba = Database.getInstancia();
		System.out.println("Connected");
	
		 HashMap<String, Object> newuser = new HashMap<String, Object>();
		 
		 newuser.put("email", "newuser6@gmail.com");
		 newuser.put("name", "jose");
		 newuser.put("username", "josenuevo6");
		 newuser.put("role_id", 1);
	
		 int user_id = prueba.insert("users" , newuser);
		 System.out.println("User inserted with user id: "+ user_id);
		
	}


}
