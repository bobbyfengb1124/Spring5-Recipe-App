/**
 * @Author Feng Bo
 * @Date 11 Aug 2017 11:07:00 am
 */
package guru.springframework.Spring5RecipeApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 */
@Controller
public class IndexController {

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		System.out.println("Some message to say... 1234");
		return "index";
	}
}
