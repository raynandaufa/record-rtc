package com.app.recording.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class RecordingController {
	
	@Value("${path.upload.dir}")
	private String pathUploadDir;

	@RequestMapping(value="/ajsrecord", method=RequestMethod.GET)
	public String loadIndex(){
		return "index";
	}
	
	@RequestMapping(value = "/recording/upload", method = RequestMethod.POST)
	public void uploadRecording(HttpServletRequest request, HttpServletResponse response) {
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile actualFile = multipartRequest.getFileMap().get("video-blob");
			String fileName = multipartRequest.getParameter("video-filename");
			actualFile.transferTo(new File(pathUploadDir + fileName));
			System.out.println("Uploading done..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	 @RequestMapping(value="/player", method=RequestMethod.GET)
	 public String loadRecord(@RequestParam String filename, HttpServletRequest request){
	 	return "player";
	 }

}
