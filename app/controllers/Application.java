package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import models.*;
import views.html.*;

public class Application extends Controller {

	static Form<Task> submitForm = new Form<Task>(Task.class);
	
    public static Result index() {
        return ok(index.render("Welcome to ToDo", submitForm, Task.all()));
    }
    
    public static Result createtask() {
    	Form<Task> bindForm = submitForm.bindFromRequest();
    	if(bindForm.hasErrors() == false) {
    		Task.create(bindForm.get());
    		submitForm = new Form<Task>(Task.class);
    		return redirect("/");
    	}
    	 return ok(index.render("Welcome to ToDo", bindForm, Task.all()));
    }
    
    public static Result deletetask(int id) {
    	return ok(delete.render(id));
    }
    
    public static Result deletetask() {
    	return TODO;
    }

}
