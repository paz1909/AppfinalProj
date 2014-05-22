package il.good.neighbor.controller;

import il.good.neighbor.model.Family;
import il.good.neighbor.model.GoodNeighborDAO;
import il.good.neighbor.model.Volunteer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;*/


/**
 * Servlet implementation class GoodNeighborServlet
 */

@WebServlet("/Controller/*")
public class GoodNeighborController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static GoodNeighborDAO instance;
	private String[] ids = null;
	private Integer familyIDInt;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public GoodNeighborController() {
		
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		switch (path) 
		{	
			case "/firstPage": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/firstPage.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			
			case "/mainPage": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/mainPage.jsp");
			    dispatcher.forward(request, response);
				break;
			}

			case "/unApproved": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/unApproved.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/unRegisteredUser": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/unRegisteredUser.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/afterSignUp": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/afterSignUp.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/volunteerMenu": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/volunteerMenu.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/rsvp": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/rsvp.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/whereToGo": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/whereToGo.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/notComing": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/notComing.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/chooseMaps": 
			{
				getServletContext().log("enter chooseMaps");
				instance = GoodNeighborDAO.getInstance();
				
				String id = request.getParameter("mapRadio");
				
				if(id !=null)
				{
					
					
				}
				else
				{
					List<?> maps = instance.getAllMaps();
					request.setAttribute("maps", maps);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/chooseMaps.jsp");
					dispatcher.forward(request, response);
				}
				getServletContext().log("exit chooseMaps");
				break;
			}
			case "/mapDits": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/mapDits.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/endOfDelivery": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/endOfDelivery.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/manager": 
			{
				if(request.getParameter("appNewVols") != null)
				{
					response.sendRedirect("approveNewVolunteers");
				}
				
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/manager.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/approveNewVolunteers":
			{
				getServletContext().log("enter approveNewVolunteers");
				instance = GoodNeighborDAO.getInstance();
				String[] ids = request.getParameterValues("checkVols");
				
				if(ids !=null)
				{
					instance.approveVolunteers(ids);
					response.sendRedirect("approveNewVolunteers");
				}
				else
				{
					List<Volunteer> volunteers = instance.getAllUnapprovedVolunteers();
					request.setAttribute("volunteers", volunteers);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/approveNewVolunteers.jsp");
					dispatcher.forward(request, response);
				}
				getServletContext().log("exit approveNewVolunteers");
				break;
			}
			case "/allVolunteers": 
			{
				getServletContext().log("enter allVolunteers");
				instance = GoodNeighborDAO.getInstance();
				List<?> volunteers = instance.getAllVolunteers();
				request.setAttribute("volunteers", volunteers);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/allVolunteers.jsp");
				dispatcher.forward(request, response);
				getServletContext().log("exit allVolunteers");
				break;
			}
			case "/allFamilies": 
			{
				getServletContext().log("enter allFamilies");
				instance = GoodNeighborDAO.getInstance();
				List<?> families = instance.getAllFamilies();
				request.setAttribute("families", families);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/allFamilies.jsp");
				dispatcher.forward(request, response);
				getServletContext().log("exit allFamilies");
				break;
			}
			case "/allMaps": 
			{
				getServletContext().log("enter allMaps");
				instance = GoodNeighborDAO.getInstance();
				List<?> maps = instance.getAllMaps();
				request.setAttribute("maps", maps);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/allMaps.jsp");
				dispatcher.forward(request, response);
				getServletContext().log("exit allMaps");
				break;
			}
			case "/addNewMaps": 
			{
				getServletContext().log("enter addNewMaps");
				instance = GoodNeighborDAO.getInstance();
				
				ids = request.getParameterValues("familyCheck");
				
				if(ids !=null)
				{
					response.sendRedirect("addNewMap");
				}
				else
				{
					List<Family> families = instance.getAllFamiliesWithoutMap();
					request.setAttribute("families", families);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/addNewMaps.jsp");
					dispatcher.forward(request, response);
				}
				getServletContext().log("exit addNewMaps");
				break;
			}
			case "/addNewMap": 
			{
				getServletContext().log("enter addNewMap");				
				String areaName = request.getParameter("areaName");			
				
				if(areaName !=null)
				{
					instance = GoodNeighborDAO.getInstance();
					instance.addNewMap(areaName, ids);
					response.sendRedirect("confirmNewMap");
				}
				else
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/addNewMap.jsp");
					dispatcher.forward(request, response);
				}
				getServletContext().log("exit addNewMap");
				break;
			}
			case "/addNewFamily": 
			{
				getServletContext().log("enter addNewFamily");
				
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String phoneNumber = request.getParameter("phoneNumber");
				String city = request.getParameter("city");
				String street = request.getParameter("street");
				String houseNumber = request.getParameter("houseNumber");
				String appartmentNumber = request.getParameter("appartmentNumber");
				String comments = request.getParameter("comments");
				
				if(firstName != null && lastName != null && phoneNumber != null
						&& city != null && street != null && houseNumber != null
						&& appartmentNumber != null)
				{
					Integer houseNumberInt = Integer.parseInt(houseNumber);
					Integer appartmentNumberInt = Integer.parseInt(appartmentNumber);
					instance = GoodNeighborDAO.getInstance();
					instance.addNewFamily(firstName, lastName, phoneNumber, city, street, houseNumberInt, appartmentNumberInt, comments);
				}
				else
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/addNewFamily.jsp");
					dispatcher.forward(request, response);
				}
				getServletContext().log("exit addNewFamily");
				break;
			}

			case "/confirmNewMap": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmNewMap.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/confirmDelMap": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmDelMap.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			case "/editFamily": 
			{
				getServletContext().log("enter editFamily");
				String familyID = request.getParameter("family");
				
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String phoneNumber = request.getParameter("phoneNumber");
				String city = request.getParameter("city");
				String street = request.getParameter("street");
				String houseNumber = request.getParameter("houseNumber");
				String appartmentNumber = request.getParameter("appartmentNumber");
				String comments = request.getParameter("comments");
				

				if(familyID != null)
				{
					instance = GoodNeighborDAO.getInstance();
					Family family = instance.getFamilyById(familyID);
					request.setAttribute("family", family);
					familyIDInt = Integer.parseInt(familyID);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/editFamily.jsp");
				    dispatcher.forward(request, response);
				}
				else if(firstName != null && lastName != null && phoneNumber != null
						&& city != null && street != null && houseNumber != null
						&& appartmentNumber != null)
				{
					instance = GoodNeighborDAO.getInstance();
					Integer houseNumberInt = Integer.parseInt(appartmentNumber);
					Integer streetNumberInt = Integer.parseInt(houseNumber);
					instance.updateFamilyDetails(familyIDInt, firstName, lastName, phoneNumber, city, street, streetNumberInt, houseNumberInt, comments);
					response.sendRedirect("allFamilies");
				}
				else
				{
				    RequestDispatcher dispatcher = request.getRequestDispatcher("/editFamily.jsp");
				    dispatcher.forward(request, response);
				}
			    getServletContext().log("exit editFamily");
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*case "/chooseMapsInit.jsp": 
			{
				getServletContext().log("enter chooseMapsInit");
				instance = GoodNeighborDAO.getInstance();
				List<?> maps = instance.getAllMaps();
				String json = createAllUnChoosedMapsJson(maps);
				getServletContext().log("json: " + json);
				response.getWriter().println(json);
				getServletContext().log("exit chooseMapsInit");
				break;
			}
			
			case "/allVolunteersInit.jsp": /*works
			{
				getServletContext().log("enter allVolunteersInit");
				instance = GoodNeighborDAO.getInstance();
				List<?> volunteers = instance.getAllVolunteers();
				String json = createAllVolunteersJson(volunteers);
				getServletContext().log("json: " + json);
				response.getWriter().println(json);
				getServletContext().log("exit allVolunteersInit");
				break;
			}
			
			case "/approveNewVolunteersInit.jsp": /*works
			{
				getServletContext().log("enter approveNewVolunteersInit");
				instance = GoodNeighborDAO.getInstance();
				List<?> volunteers = instance.getAllVolunteers();
				String json = createAllUnapprovedJson(volunteers);
				getServletContext().log("json" + json);
				response.getWriter().println(json);
				getServletContext().log("exit approveNewVolunteersInit");
				break;
			}
			
			case "/approveNewVolunteers.jsp": /*works
			{
				getServletContext().log("enter approveNewVolunteers");
				String json = request.getHeader("json");
				getServletContext().log("json:" +  json);
				instance = GoodNeighborDAO.getInstance();
				List<String> toApprove = getListOfIDsToAporoveFromjson(json);
				for (String volunteerId : toApprove) {
					instance.approveNewVolunteer(volunteerId);
				}
				getServletContext().log("exit approveNewVolunteers");
				break;
			}
			
			case "/addNewMap.jsp": 
			{
				getServletContext().log("enter addNewMap");
				String mapJson = request.getHeader("mapToAdd");
				getServletContext().log("mapJson" +  mapJson);
				instance = GoodNeighborDAO.getInstance();
				Map map = createMapFromJson(mapJson);
				instance.addMap(map);
				response.getWriter().println("map added");
				getServletContext().log("enter addNewMap");
				break;
			}
			
			case "/signUp.jsp": /*works
			{
				getServletContext().log("enter signUp");
				String id = request.getHeader("id");
				String firstName = request.getHeader("firstName");
				String lastName = request.getHeader("lastName");
				String phoneNumber = request.getHeader("phoneNumber");
				String email = request.getHeader("email");
				String userName = request.getHeader("userName");
				String password = request.getHeader("password");
				instance = GoodNeighborDAO.getInstance();
				getServletContext().log("volunteer id : "+id);
				getServletContext().log("volunteer firstName : "+firstName);
				getServletContext().log("volunteer lastName : "+lastName);
				getServletContext().log("volunteer phoneNumber : "+phoneNumber);
				getServletContext().log("volunteer email : "+email);
				getServletContext().log("volunteer userName : "+userName);
				getServletContext().log("volunteer password : "+password);
				boolean answer = instance.addVolunteer(id, firstName, lastName, email, phoneNumber, userName, password);
				getServletContext().log("volunteer answer : "+answer);
				response.getWriter().println(String.valueOf(answer));
				getServletContext().log("exit signUp");
				break;
			}
			
			case "/signIn.jsp": /*works
			{
				getServletContext().log("enter signIn");
				String userName = request.getHeader("userName");
				String password = request.getHeader("password");
				instance = GoodNeighborDAO.getInstance();
				String answer = instance.signIn(userName, password);
				getServletContext().log("signIn answer : "+answer);
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(answer);
				getServletContext().log("exit signIn");
				break;
			}
			
			case "/allMapsInit.jsp": /*works
			{
				getServletContext().log("enter allMapsInit");
				instance = GoodNeighborDAO.getInstance();
				List<?> maps = instance.getAllMaps();
				String json = createAllMapsJson(maps);
				getServletContext().log("json: " + json);
				response.getWriter().println(json);
				getServletContext().log("exit allMapsInit");
				break;
			}
			
			case "/allFamiliesInit.jsp": /* works 
			{
				getServletContext().log("enter allFamiliesInit");
				instance = GoodNeighborDAO.getInstance();
				List<?> families = instance.getAllFamilies();
				String json = createAllFamiliesJson(families);
				getServletContext().log("json: " + json);
				response.getWriter().println(json);
				getServletContext().log("exit allFamiliesInit");
				break;
			}
			
			case "/mapDitsInit.jsp": /* need session ?.. 
			{
				
			}
			
			case "/stam.jsp": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/stam.jsp");
			    dispatcher.forward(request, response);
				break;
			}
			
			case "/test.jsp": 
			{
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/test.jsp");
			    dispatcher.forward(request, response);
				break;
			}*/
			
		}
	}

	/*private String createAllFamiliesJson(List<?> families) {
		JSONObject json;
		JSONObject familyObj;
		json = new JSONObject();
		try 
		{
			Iterator<?> iterator = families.iterator();
			while (iterator.hasNext()) 
			{
				Family family = (Family) iterator.next();
				familyObj = new JSONObject();
				
				familyObj.put("firstName", family.getFirstName());
				familyObj.put("lastName", family.getLastName());
				familyObj.put("phoneNumber", family.getPhoneNumber());
				familyObj.put("city", family.getCity());
				familyObj.put("street", family.getStreet());
				familyObj.put("comments", family.getComments());
				familyObj.put("streetNumber", family.getStreetNumber());
				familyObj.put("houseNumber", family.getHouseNumber());
				
				Map m = family.getMap();
				if(m != null)
				{
					familyObj.put("mapRelatedName", m.getAreaName());
				}
				json.accumulate("families", familyObj);
			}
			json.put("familiesLength", families.size());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	private String createAllUnChoosedMapsJson(List<?> maps) {
		JSONObject json;
		JSONObject mapObj;
		JSONObject familyObj;
		json = new JSONObject();
		int UnChoosedCount = 0;
		try {
			Iterator<?> iterator = maps.iterator();
			while (iterator.hasNext()) 
			{
				Map map = (Map) iterator.next();
				if(map.getIsChosenToday() == false)
				{
					UnChoosedCount ++;
					Set<?> families = map.getFamilies();
					mapObj = new JSONObject();
					mapObj.put("mapName", map.getAreaName());
					mapObj.put("familiesLength", families.size());
					
					Iterator<?> familyIterator = map.getFamilies().iterator();
					while (familyIterator.hasNext())
					{
						Family family = (Family) familyIterator.next();
						familyObj = new JSONObject();
						familyObj.put("firstName", family.getFirstName());
						familyObj.put("lastName", family.getLastName());
						familyObj.put("phoneNumber", family.getPhoneNumber());
						familyObj.put("city", family.getCity());
						familyObj.put("street", family.getStreet());
						familyObj.put("comments", family.getComments());
						familyObj.put("streetNumber", family.getStreetNumber());
						familyObj.put("houseNumber", family.getHouseNumber());
						
						mapObj.accumulate("families", familyObj);
					}	
					json.accumulate("maps", mapObj);
				}
			}
			json.put("mapsLength", UnChoosedCount);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return json.toString();
	}

	private List<String> getListOfIDsToAporoveFromjson(String json) {
		List<String> IDsToApprove = new ArrayList<>();
		try {
			JSONObject volunteersToAdd = new JSONObject(json);
			int length = volunteersToAdd.getInt("arrayLength");
			JSONArray arr;
			JSONObject obj;
			if(length > 1)
			{
				arr = volunteersToAdd.getJSONArray("volunteers");
				for(int i = 0; i < arr.length() ; i++)
				{
					JSONObject volunteerObj = arr.getJSONObject(i);
					IDsToApprove.add(volunteerObj.getString("id"));
				}
			}
			else
			{
				obj = volunteersToAdd.getJSONObject("volunteers");
				IDsToApprove.add(obj.getString("id"));
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return IDsToApprove;
	}

	private Map createMapFromJson(String familiesToAdd) 
	{
		Map mapToRet = new Map();
		try {
			JSONObject json = new JSONObject(familiesToAdd);
			mapToRet.setAreaName(json.getString("mapName"));
			int length = json.getInt("familiesLength");
			mapToRet.setIsChosenToday(false);
			mapToRet.setIsSaved(false);
			if(length > 1)
			{
				JSONArray arr = json.getJSONArray("families");
				for(int i = 0; i < arr.length() ; i++)
				{
					JSONObject familyObj = arr.getJSONObject(i);
					String firstName = familyObj.getString("firstName");
					String lastName = familyObj.getString("lastName");
					String phoneNumber = familyObj.getString("phoneNumber");
					String city = familyObj.getString("city");
					String street = familyObj.getString("street");
					String comments = familyObj.getString("comments");
					int streetNumber = familyObj.getInt("streetNumber");
					int houseNumber = familyObj.getInt("houseNumber");
					Family f = new Family(firstName, lastName, phoneNumber, city, street, streetNumber, houseNumber, comments, mapToRet);
					mapToRet.getFamilies().add(f);
				}
			}
			else
			{
				JSONObject obj = json.getJSONObject("families");
				String firstName = obj.getString("firstName");
				String lastName = obj.getString("lastName");
				String phoneNumber = obj.getString("phoneNumber");
				String city = obj.getString("city");
				String street = obj.getString("street");
				String comments = obj.getString("comments");
				int streetNumber = obj.getInt("streetNumber");
				int houseNumber = obj.getInt("houseNumber");
				Family f = new Family(firstName, lastName, phoneNumber, city, street, streetNumber, houseNumber, comments, mapToRet);
				mapToRet.getFamilies().add(f);
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return mapToRet;
	}

	private String createAllUnapprovedJson(List<?> volunteers) {
		JSONObject json;
		json = new JSONObject();
		int unApprovedCount = 0;
		try {
			Iterator<?> iterator = volunteers.iterator();
			while (iterator.hasNext()) 
			{
				Volunteer volunteer = (Volunteer) iterator.next();
				if(volunteer.isApproved() == false)
				{
					unApprovedCount ++;
						json.accumulate("volunteers", new JSONObject()
							    .put("id", volunteer.getId())
								.put("firstName", volunteer.getFirstName())
								.put("lastName", volunteer.getLastName())
								.put("phone", volunteer.getPhoneNumber())
								.put("email", volunteer.getEmail())
								.put("userName", volunteer.getUserName()));
				}
			}
			json.put("volLength", unApprovedCount);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return json.toString();
	}
	
	private String createAllVolunteersJson(List<?> volunteers) {
		JSONObject json;
		json = new JSONObject();
		try 
		{
			Iterator<?> iterator = volunteers.iterator();
			while (iterator.hasNext()) 
			{
				Volunteer volunteer = (Volunteer) iterator.next();
	
					json.accumulate("volunteers", new JSONObject()
						    .put("id", volunteer.getId())
							.put("firstName", volunteer.getFirstName())
							.put("lastName", volunteer.getLastName())
							.put("phone", volunteer.getPhoneNumber())
							.put("email", volunteer.getEmail())
							.put("userName", volunteer.getUserName()));
			}
			json.put("volLength", volunteers.size());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	private String createAllMapsJson(List<?> maps) { 
		
		JSONObject json;
		JSONObject mapObj;
		JSONObject familyObj;
		JSONObject volunteerObj;
		json = new JSONObject();
		
		try 
		{
			json.put("mapsLength", maps.size());
			Iterator<?> iterator = maps.iterator();
			while(iterator.hasNext())
			{
				Map map = (Map) iterator.next();
				Volunteer vol = map.getVolunteer();
				Set<?> families = map.getFamilies();
				mapObj = new JSONObject();
				volunteerObj = new JSONObject();
				mapObj.put("mapName", map.getAreaName());
				if(vol != null)
				{
					mapObj.put("isSavedToVolunteer", true);
					volunteerObj.put("firstName", vol.getFirstName());
					volunteerObj.put("lastName", vol.getLastName());
					mapObj.put("volunteer", volunteerObj);
				}
				else
				{
					mapObj.put("isSavedToVolunteer", false);
				}	
				mapObj.put("familiesLength", families.size());
				
				Iterator<?> familyIterator = families.iterator();
				while(familyIterator.hasNext())
				{
					Family family = (Family) familyIterator.next();
					familyObj = new JSONObject();
					familyObj.put("firstName", family.getFirstName());
					familyObj.put("lastName", family.getLastName());
					familyObj.put("phoneNumber", family.getPhoneNumber());
					familyObj.put("city", family.getCity());
					familyObj.put("street", family.getStreet());
					familyObj.put("comments", family.getComments());
					familyObj.put("streetNumber", family.getStreetNumber());
					familyObj.put("houseNumber", family.getHouseNumber());
					
					mapObj.accumulate("families", familyObj);
				}
				json.accumulate("maps", mapObj);
			}
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return json.toString();
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		switch (path) 
		{	
			case "/mainPage": 
			{
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				
				if(userName != null && password != null)
				{
					instance = GoodNeighborDAO.getInstance();
					String redirectURL = instance.signIn(userName, password);
					switch (redirectURL) {
					case "false":
						/*popup*/
						break;
					case "falseManager":
						/*popup*/
						break;
					default:
						response.sendRedirect(redirectURL);
						break;
					}
					
				}
				else
				{
				    RequestDispatcher dispatcher = request.getRequestDispatcher("/mainPage.jsp");
				    dispatcher.forward(request, response);
				}
				break;
			}
		}
	}
}
