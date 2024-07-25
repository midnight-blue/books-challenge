package de.servicehealth.lost_and_found;

import de.servicehealth.lost_and_found.model.Position;
import de.servicehealth.lost_and_found.model.SearchItem;
import de.servicehealth.lost_and_found.model.SearchItems;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.time.Instant;
import java.util.List;

public class LostAndFoundTest {

	@Test
	public void testLostAndFound() {
		var items = this.loadResource("lost_and_found/foundData.yaml", SearchItems.class);

		List<SearchItem> foundItems = loadItems("lost_and_found/foundData.yaml");
		List<SearchItem> lostItems = loadItems("lost_and_found/lostData.yaml");

	}

	private <T> T loadResource(String path, Class<T> clazz) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
		var loaderOption = new LoaderOptions();
		loaderOption.setEnumCaseSensitive(false);
		Yaml yaml = new Yaml(new Constructor(clazz, loaderOption));
		return yaml.load(inputStream);
	}

	private List<SearchItem> loadItems(String path) {
		var items = this.loadResource(path, SearchItems.class);
		return items.elements.stream().map(item ->
				new SearchItem(item.description, Instant.parse(item.time), Position.fromString(item.location))).toList();
	}

}
