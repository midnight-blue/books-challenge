package de.servicehealth.javachallenge;

import de.servicehealth.javachallenge.model.Element;
import de.servicehealth.javachallenge.util.Elements;
import de.servicehealth.javachallenge.util.Expected;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookOrganizerTest {

	private final BookOrganizer organizer = new BookOrganizer();

	@Test
	public void testOrganize() {
		var elements = this.loadElements("simpleHierarchy");
		var result = organizer.organize(elements);
		checkAgainstExpected("simpleHierarchy", result);

	}

	@Test
	public void getCycle() {
		var elements = this.loadElements("cycle");
		var result = organizer.organize(elements);
		checkAgainstExpected("cycle", result);

	}


	private void checkAgainstExpected(String testCase, Collection<String> results) {
		List<String> expected = this.loadExpected(testCase);
		var sortedResult = results.stream().sorted().toList();
		for (int i = 0; i < sortedResult.size(); i++) {
			assertEquals(sortedResult.get(i), expected.get(i));
		}
	}

	private Collection<Element> loadElements(String testCase) {
		Elements elements = loadResource("cases/" + testCase + "/input.yaml", Elements.class);
		return elements.getElements();
	}

	private List<String> loadExpected(String testCase) {
		Expected elements = loadResource("cases/" + testCase + "/expected.yaml", Expected.class);
		return elements.getExpected();
	}


	private <T> T loadResource(String path, Class<T> clazz) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
		var loaderOption = new LoaderOptions();
		loaderOption.setEnumCaseSensitive(false);
		Yaml yaml = new Yaml(new Constructor(clazz, loaderOption));
		return yaml.load(inputStream);
	}
}
