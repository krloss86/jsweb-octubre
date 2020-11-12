package ar.com.educacionit.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Menu;

public final class MenuBuilder {

	//atributo de clase
	private static Set<Menu> itemsMenu = buildMenu();//atributo de instancia
	
	//metodo static, de clase
	private static Set<Menu> buildMenu() {
	
		try {
			MenuDAO menuDao = new MenuDAO();
		
			Collection<Menu> items = menuDao.findMenu();
			
			itemsMenu = new HashSet<Menu>(items);
		} catch (GenericException e) {
			itemsMenu = new HashSet<Menu>();
		}
		
		return itemsMenu;
	}
	
	public final static String textoMenu() { //metodo de clase
	
		StringBuffer menuStr = new StringBuffer();
		
		List<Menu> listItems = new ArrayList<>(itemsMenu);
		
		//ordenamos el menu
		Collections.sort(listItems);
		
		for(Menu menu : listItems) {
			menuStr.append(menu.getOpcion()).append(" - ").append(menu.getDescripcion());
			menuStr.append("\n");
		}
		
		return menuStr.toString();
	}
	
	//metodo para recargar los items!
}
