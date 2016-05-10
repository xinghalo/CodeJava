package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParamController {
	@RequestMapping(value="/param1")
	public @ResponseBody String param1(@RequestParam("name") String name){
		return name;
	}
	@RequestMapping(value="/param2")
	public @ResponseBody String param2(@RequestParam(value="name",required=false) String name){
		return name;
	}
	@RequestMapping(value="/param3")
	public @ResponseBody String param3(@RequestParam(value="name",required=false,defaultValue="xingoo") String name){
		return name;
	}
	
	@RequestMapping(value="/path/{name}")
	public @ResponseBody String path1(@PathVariable(value="name") String name){
		return name;
	}
}
