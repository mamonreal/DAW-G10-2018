package error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

	@RequestMapping("/error")
	public String error(Model model) {
		return "error";
	}
}
