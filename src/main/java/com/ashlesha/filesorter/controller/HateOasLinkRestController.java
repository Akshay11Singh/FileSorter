package com.ashlesha.filesorter.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HateOasLinkRestController {

	@RequestMapping("hateoas")
	public List hateoasLink() {
	/*	Link link = ControllerLinkBuilder.linkTo(HateOasLinkRestController.class).slash(employee.getEmployeeId())
				.withSelfRel();*/
		return new LinkedList();
	}
}
