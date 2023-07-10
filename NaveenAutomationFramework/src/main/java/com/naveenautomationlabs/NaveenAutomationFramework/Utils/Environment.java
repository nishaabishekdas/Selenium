package com.naveenautomationlabs.NaveenAutomationFramework.Utils;

public enum Environment {
	DEV("Dev", "https://naveenautomationlabsDev.com/opencart/index.php?route=common/home"),
	STAGE("Stage", "https://naveenautomationlabsstage.com/opencart/index.php?route=common/home"),
	QA("qa", "https://naveenautomationlabsqa.com/opencart/index.php?route=common/home"),
	PROD("Production", "https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	String env;
	String url;

	private Environment(String env, String url) {
		this.env = env;
		this.url = url;
	}

	public String getEnv() {
		return env;
	}

	public String getUrl() {
		return url;
	}

}
