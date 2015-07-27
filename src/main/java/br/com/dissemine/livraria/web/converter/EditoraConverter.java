package br.com.dissemine.livraria.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@FacesConverter(forClass=Editora.class)
public class EditoraConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(string);
		return JPAUtil.getEntityManager().find(Editora.class, id); 
	}

	@Override
	public String getAsString(FacesContext contect, UIComponent component, Object object) {
		Editora editora = (Editora)object;
		if (editora == null || editora.getId() == null) {
			return null;
		}
		return String.valueOf(editora.getId());
	}

}
