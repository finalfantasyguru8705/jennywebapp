package com.jenny.jennywebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jenny.jennywebapp.service.VideoService;

import java.util.ArrayList;

@Controller
public class VideoController {
	@Autowired
	VideoService videoService;

	@RequestMapping(value = "/videos", method= RequestMethod.GET )
	//produces = MediaType.
	public ModelAndView startVideoController() {
		System.out.println("Printing in com.jenny.jennywebapp.controller:" + this.getClass().getSimpleName());
		ModelAndView videoPageModelView = new ModelAndView("videoPage");
        ArrayList<String> listOfVideos = videoService.getAllVideosAsString();
		videoPageModelView.addObject("videos", listOfVideos);
		return videoPageModelView;
	}
}
