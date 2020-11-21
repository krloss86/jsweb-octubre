package ar.com.educacionit.web.parsers;

import java.io.IOException;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public interface IFileParser {

	public Collection<Producto> parse() throws IOException;
}
