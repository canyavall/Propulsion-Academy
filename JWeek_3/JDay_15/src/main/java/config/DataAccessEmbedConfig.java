package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ActiveProfiles("dev")
@Import(DataAccessConfig.class)
public class DataAccessEmbedConfig {

	@Bean
	public DataSource dataSource() {
	  return new EmbeddedDatabaseBuilder()
			  .setType(EmbeddedDatabaseType.H2)
			  .generateUniqueName(true)
			  .addScript("schema.sql")
			  .build();
	}
}
