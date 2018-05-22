package es.upm.dit.isst.wifiway.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.wifiway.dao.UserDAOImplementation;
import es.upm.dit.isst.wifiway.dao.model.*;
import es.upm.dit.isst.wifiway.dao.*;

@WebServlet("/CacheServlet")
public class CacheServlet extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		
		
		User user = UserDAOImplementation.getInstance().readUser(email);
		
		

		if (null != user) {
			String cache[] = user.getPuntos();
			JsonArrayBuilder array = Json.createArrayBuilder();
			for(int i = 0; i < cache.length; i++) {
				String position[] = cache[i].split("&");
				JsonObjectBuilder point = Json.createObjectBuilder()
		                .add("lat", position[0])
		                .add("lng", position[1])
		                ;
				array.add(point);
				
			}
			JsonArray sol = array.build();
			
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(sol);
			out.close();

		}

		else {
			
		}
	}
	
}

