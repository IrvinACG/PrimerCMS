package com.iacg.component;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.iacg.model.GrupoPermiso;
import com.iacg.repository.CategoriaRepository;
import com.iacg.repository.ComentarioRepository;
import com.iacg.repository.ContenidoRepository;
import com.iacg.repository.GrupoPermisoRepository;
import com.iacg.repository.GrupoRepository;
import com.iacg.repository.PermisoRepository;
import com.iacg.repository.PostMetadataRepository;
import com.iacg.repository.PostRepository;
import com.iacg.repository.UsuarioMetadataRepository;
import com.iacg.repository.UsuarioRepository;

@Configuration
public class TestDataBaseConfiguration {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test_dbspring");
		dataSource.setUsername("irvincg");
		dataSource.setPassword("12345");		
		return dataSource;
	}
	
	@Bean
	public CategoriaRepository categoriaRepository() {return new CategoriaRepository();	}
	@Bean
	public ComentarioRepository comentarioRepository() {return new ComentarioRepository();	}
	@Bean
	public ContenidoRepository contenidoaRepository() {return new ContenidoRepository();	}
	@Bean
	public GrupoPermisoRepository grupoPermisoRepository() {return new GrupoPermisoRepository();	}
	@Bean
	public GrupoRepository grupoRepository() {return new GrupoRepository();	}
	@Bean
	public PermisoRepository permisoRepository() {return new PermisoRepository();	}
	@Bean
	public PostRepository postRepository() {return new PostRepository();	}
	@Bean
	public PostMetadataRepository postMetadataRepository() {return new PostMetadataRepository();	}
	@Bean
	public UsuarioRepository usuarioRepository() {return new UsuarioRepository();	}
	@Bean
	public UsuarioMetadataRepository usuarioMetadataRepository() {return new UsuarioMetadataRepository();	}
}
