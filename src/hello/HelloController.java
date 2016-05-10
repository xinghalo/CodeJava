package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public @ResponseBody String get(){
    	return "from get";
    }
    @RequestMapping(value="/test",method=RequestMethod.POST)
    public @ResponseBody String post(){
    	return "from post";
    }
}