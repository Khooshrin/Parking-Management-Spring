package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.UserDetails;
import com.example.demo.model.WorkerDetails;
import com.example.demo.service.DetailsService;
import com.example.demo.service.WorkersService;

@Controller
public class ParkingController {
	
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private WorkersService workersService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listDetails", detailsService.getAllUserDetailss());
		return "index";
	}
	
	@PostMapping("/addWorker")
	public String addWorker(@ModelAttribute("WorkerDetails") WorkerDetails workerDetails) {
		workersService.saveWorkerDetails(workerDetails);
		return "redirect:/admin"; 
	}
	
	@GetMapping("/register")
	public String Register(Model model) {
		UserDetails userDetails=new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "Register";
	}
	
	@GetMapping("/deleteWorker/{Name}")
	public String deleteWorker(@PathVariable (value="Name") String Name) {
		this.workersService.deleteWorkerById(Name);
		return "redirect:/admin";
	}
	
	@PostMapping("/saveDetails")
	public String saveDetails(@ModelAttribute("UserDetails") UserDetails userDetails) {
		if((userDetails.getPassword()).compareTo(userDetails.getConfPassword())==0)
		{
			detailsService.saveUserDetails(userDetails);
			return "redirect:/login";
		}
		else
			return "redirect:/register";
	}
	
	@GetMapping("/logout")
	public String Logout()
	{
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String Login(Model model) {
		UserDetails userDetails=new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "Login";
	}
	
	@GetMapping("/dashboard")
	public String Dashboard() {
		return "Dashboard";
	}
	
	@GetMapping("/add")
	public String addWorker(Model model) {
		WorkerDetails workerDetails=new WorkerDetails();
		model.addAttribute("workerDetails", workerDetails);
		return "AddWorker";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("listWorkers", workersService.getAllWorkerDetailss());
		return "admin";
	}
	
	@PostMapping("/processDetails")
	public String Dashboard(@ModelAttribute("UserDetails") UserDetails userDetails)
	{
		if(detailsService.findUser(userDetails)==true && (userDetails.getUsername()).compareTo("admin")==0)
		return "redirect:/admin";
		else if(detailsService.findUser(userDetails)==true)
		return "redirect:/dashboard";
		else
		return "redirect:/login";
	}
}
