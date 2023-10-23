package pojoCreator;

import java.io.File;
import java.io.IOException;

public class PojoMainClass {
	public static void main(String[] arg) throws IOException {
		CreatePojoFromJson createPojoFromJson = new CreatePojoFromJson();

		String outputFileDirectory = "src/main/java/";
		File file = new File(outputFileDirectory);
		createPojoFromJson.convertJsonToJavaClass(file, "response.createIssueResponse",
				"createIssueResponse",
				utils.JsonReader.readJsonFile("createIssue.json").toString());
	}
}
