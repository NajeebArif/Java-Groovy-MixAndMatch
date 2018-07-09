package narif.poc.groovy.groovygoodies;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.codehaus.groovy.control.CompilationFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * Unit test for simple App.
 */
@DisplayName("Application Specification:")
public class AppTest {

	@DisplayName("When 1 is added 2 then sum should be 3")
	@Test
	public void checkAddition() {
		App app = new App();
		assertThat(app.add(1, 2)).isNotNull().isEqualTo(3);
	}

	@Test
	@DisplayName("The Groovy Script runs, prints \"Hello World\" and then returns \"Hello\"")
	public void checkGroovyScript() throws CompilationFailedException, IOException {
		Path p = Paths.get("simpleScript.groovy");
		final File scriptFile = p.toFile();
		GroovyShell shell = new GroovyShell();
		Script script = shell.parse(scriptFile);
		Object result = script.run();
		assertThat(result.toString()).isNotNull().isNotEmpty().isNotBlank().isEqualTo("Hello");
	}

}
