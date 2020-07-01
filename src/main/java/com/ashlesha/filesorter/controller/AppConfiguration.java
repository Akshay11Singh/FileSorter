package com.ashlesha.filesorter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ashlesha-file-sorter")
public class AppConfiguration {

	AppConfiguration() {

	}

	@Value("${spring.application.name}")
	private String appName;

//	@Value("${application.name}")
	private String gitName;

	private String test;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ AppConfiguration:" + appName + " ]";
	}

	public String getGitName() {
		return gitName;
	}

	public void setGitName(String gitName) {
		this.gitName = gitName;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
