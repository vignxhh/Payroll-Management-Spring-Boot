package project.mini.services;


import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import jakarta.servlet.http.HttpSession;



@Component
public class SessionHelper {
	

	public void removeMessageFromSession(){
		
		try {
			HttpSession session=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			session.removeAttribute("nocomp");
			session.removeAttribute("regid");
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
		
	}
}
