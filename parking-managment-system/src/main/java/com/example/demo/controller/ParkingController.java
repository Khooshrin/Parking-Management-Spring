package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.BookingDetails;
import com.example.demo.model.UserDetails;
import com.example.demo.model.WorkerDetails;
import com.example.demo.service.BookingService;
import com.example.demo.service.DetailsService;
import com.example.demo.service.WorkersService;

@Controller
public class ParkingController {
	
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private WorkersService workersService;
	@Autowired
	private BookingService bookingService;
	BookingDetails bookingDetails=new BookingDetails();
	LocalDate currentdate = LocalDate.now();
	static String UName;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listDetails", detailsService.getAllUserDetailss());
		return "index";
	}
	
	
	@PostMapping("/addWorker")
	public String addWorker(@ModelAttribute("WorkerDetails") WorkerDetails workerDetails) {
		workersService.saveWorkerDetails(workerDetails);
		if(UName.compareTo("admin")==0)
		return "redirect:/admin"; 
		else
		return "FeedbackSubmitted";
	}
	
	@GetMapping("/modify")
	public String Modify(Model model)
	{
		BookingDetails bookingDetails=bookingService.getBookingDetailsById(UName);
		model.addAttribute("bookingDetails", bookingDetails);
		return "Modify";
	}
	
	@GetMapping("/register")
	public String Register(Model model) {
		UserDetails userDetails=new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "Register";
	}
	
	@GetMapping("/rate")
	public String Rate(Model model) {
		WorkerDetails workerDetails=new WorkerDetails();
		model.addAttribute("workerDetails", workerDetails);
		return "Billpayment";
	}
	
	@GetMapping("/deleteWorker/{Name}")
	public String deleteWorker(@PathVariable (value="Name") String Name) {
		this.workersService.deleteWorkerById(Name);
		return "redirect:/admin";
	}
	
	@PostMapping("/saveDetails")
	public String saveDetails(@ModelAttribute("UserDetails") UserDetails userDetails) {
		bookingDetails.setUsername(userDetails.getUsername());
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
	public String Dashboard(Model model) {
		//bookingDetails.setUsername(this.bookingDetails.getUsername());
		bookingDetails.setUsername(UName);
		model.addAttribute("bookingDetails",bookingDetails);
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
		model.addAttribute("listBooking", bookingService.getAllBookingDetailss());
		return "admin";
	}
	
	@PostMapping("/processDetails")
	public String Dashboard(@ModelAttribute("UserDetails") UserDetails userDetails )
	{
		UName=userDetails.getUsername();
		if(detailsService.findUser(userDetails)==true && (userDetails.getUsername()).compareTo("admin")==0)
		return "redirect:/admin";
		else if(detailsService.findUser(userDetails)==true)
		return "redirect:/dashboard";
		else
		return "redirect:/login";
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/saveBooking")
	public String saveBooking(@ModelAttribute("BookingDetails") BookingDetails bookingDetails) {
		//bookingDetails.setUsername(this.bookingDetails.getUsername());
		bookingDetails.setUsername(UName);
		Date chosenDate=new Date(bookingDetails.getYear(),bookingDetails.getMonth(),bookingDetails.getDate());
		Date currentDate=new Date();
		if(currentDate.compareTo(chosenDate)<0 || (currentDate.compareTo(chosenDate)==0 && bookingDetails.getCheckInHour()<24 && bookingDetails.getCheckInMinute()<60 && bookingDetails.getCheckOutHour()<24 && bookingDetails.getCheckOutMinute()<60 && bookingDetails.getCheckOutHour()-bookingDetails.getCheckInHour()<=12 && (!(bookingDetails.getCheckOutHour()<bookingDetails.getCheckInHour() || bookingDetails.getCheckOutMinute()<bookingDetails.getCheckInMinute()))))
		{
			bookingService.saveBookingDetails(bookingDetails);
			return "ConfirmedBooking";
		}
		else
			return "redirect:/dashboard";
	}
	
	@GetMapping("/cancel")
	public String cancelBooking() {
		this.bookingService.deleteBookingById(UName);
		return "Cancel";
	}
	
	@PostMapping("/updateRatings")
	public String updateRatings(Model model) {
		WorkerDetails workerDetails=new WorkerDetails();
		model.addAttribute("workerDetails", workerDetails);
		return "FeedbackSubmitted";
	}
	
}
