package spring.mvc.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.service.ImageService;

@Controller
public class ImagesController {

	@Autowired
	ImageService imageService;

	@RequestMapping(value="/images", method = RequestMethod.GET)
	public ModelAndView startImageController() {
		System.out.println("Printing in controller:" + this.getClass().getSimpleName());
		ModelAndView imagePageModelView = new ModelAndView("imagePage");
		 ArrayList<String> imagesList = imageService.getAllImagesAsString();
		System.out.println(imagesList.size());
		System.out.println(imagesList);
		imagePageModelView.addObject("message", "Here are some cool Final Fantasy images:");
		imagePageModelView.addObject("images", imagesList);
		return imagePageModelView;
	}

}
