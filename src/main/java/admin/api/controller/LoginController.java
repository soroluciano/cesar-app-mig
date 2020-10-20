package admin.api.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import admin.api.model.User;

@RestController
//@Validated
public class LoginController {
//	@Autowired
//	private CustomUserDetailsService userService;



//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	@CrossOrigin()
//	@ResponseBody
//	@GetMapping("/login")
//	public  Boolean login() {
//		return true;
//		
//	}
	@CrossOrigin()
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
//	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	public @ResponseBody String signup() {
//		//ModelAndView modelAndView = new ModelAndView();
//		User user = new User();
////		modelAndView.addObject("user", user);
////		modelAndView.setViewName("signup");
//		return "signup";
//	}
	@CrossOrigin()
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Boolean createNewUser(@Valid @RequestBody User user, BindingResult bindingResult) {
//		ModelAndView modelAndView = new ModelAndView();
//	
//		User userExists = userService.findUserByEmail(user.getEmail());
//		if (userExists != null) {
//			return false;
////			bindingResult.rejectValue("email", "error.user",
////					"There is already a user registered with the username provided");
//		}else {
//			try {
//				 userService.saveUser(user);
//			} catch (Exception e) {
//				return false;
//			}
//			
//			
//		}
//		
////		if (bindingResult.hasErrors()) {
////			modelAndView.setViewName("signup");
////		} else {
////			userService.saveUser(user);
////			modelAndView.addObject("successMessage", "User has been registered successfully");
////			modelAndView.addObject("user", new User());
////			modelAndView.setViewName("login");
////
////		}
//		return modelAndView;
		return true;
	}

//	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//	public @ResponseBody User dashboard() {
////		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////		return  userService.findUserByEmail(auth.getName());
////		
//////		modelAndView.addObject("currentUser", user);
//////		modelAndView.addObject("fullName", "Welcome " + user.getFullname());
//////		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//////		modelAndView.setViewName("dashboard");
//////		return modelAndView;
//	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
