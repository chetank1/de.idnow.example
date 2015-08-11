package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Company;
import models.Identification;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.*;

public class RestController extends Controller {
	
	private static List<Identification> identiList = new ArrayList<Identification>();
	private static List<Company> companyList = new ArrayList<Company>();

	
    public Result startIdentification() {
    	//Get the parsed JSON data
    	JsonNode json = request().body().asJson();
    	if(json == null) {
    	    return badRequest("Expecting Json data");
    	  } else {
    		  int id = json.findPath("id").asInt();
    		  String name = json.findPath("name").asText();
    		  int time = json.findPath("time").asInt();
    		  int waiting_time = json.findPath("waiting_time").asInt();
    		  int companyid = json.findPath("companyid").asInt();
    		  
    		  Identification newid = new Identification(id, name, time, waiting_time, companyid);
    		  identiList.add(newid);
    	  }
    	
    	//Do something with the identification
    	
    	
        return ok();
    }


	public Result addCompany() {
    	//Get the parsed JSON data
    	JsonNode json = request().body().asJson();
    	if(json == null) {
    	    return badRequest("Expecting Json data");
    	  } else {
    		  int id = json.findPath("id").asInt();
    		  Company c = Company.COMPANY_MAP.get(id);
    		  if (c != null)
    			  return badRequest("Company with the id already exist");
    		  else
    		  {
    			  String name = json.findPath("name").asText();
    			  int sla_time = json.findPath("sla_time").asInt();
    			  float sla_percentage = (float) json.findPath("sla_percentage").asDouble();
    			  float current_sla_percentage = (float) json.findPath("current_sla_percentage").asDouble();
    			  Company newComp = new Company(id, name, sla_time, sla_percentage, current_sla_percentage);
    			  Company.COMPANY_MAP.put(id, newComp);
    		  }

    	  }
    	//Do something with the company
    	
        return ok();
    }

    public Result identifications() {
    	//JsonNode identifications = Json.newArray();
    	
    	//identifications.
    	//Get the current identification
    	//Compute correct order
    	//Create new identification JSON with JsonNode identification = Json.newObject();
    	//Add identification to identifications list 
    	Collections.sort(identiList);
        return ok(Json.toJson(identiList));
    }

}
