package sistema.beans;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SlideEndEvent;

import enumeration.EnumSexo;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.service.CategoriaService;

@ManagedBean(eager=true)
@ApplicationScoped
public class CategoriaMB {
	private static final Enumeration<EnumSexo> Masculino = null;
	private static final Enumeration<EnumSexo> Feminino = null;
	private CategoriaService service = new CategoriaService();
	private Categoria categoria = new Categoria();
	private static Campeonato camp;


	@PostConstruct
    public void init() {
		service = new CategoriaService();
		categoria = new Categoria();
    }
	public void salvar()
	{
		System.out.println(camp);
		service.salvar(categoria);
		if(camp.getCategorias()==null)
			camp.setCategorias(new ArrayList<Categoria>());
		camp.getCategorias().add(categoria);
		categoria = new Categoria();
	}
	
	//classe que pega a lista de categoria vindo da data tagle do campeonato
	@SuppressWarnings("unchecked")
	public void editarCategoria(ActionEvent event)
	{
		List<Categoria> lista = (List<Categoria>)event.getComponent().getAttributes().get("categorias");
		camp = (Campeonato)event.getComponent().getAttributes().get("campeonato");
		if (lista!=null&&lista.size()>0)
			setCategorias(lista);
		
		else
			setCategorias(new ArrayList<Categoria>());
		categoria.setCampeonato(camp);
	}
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void remover (Categoria categoria)
	{
		service.remove(categoria);
	}

	public void setCategorias(List<Categoria> categorias) {
		service.setCategorias(categorias);
	}
	public List<Categoria> getCategorias() {
		return service.getCategorias();
	}
	
	
	public int getMaxJogadores() {
        return this.categoria.getMaxJogadores();
    }
 
    public void maxJogadores(int maxJogadores) {
        this.categoria.setMaxJogadores(maxJogadores);
    }
    
//	public int getMaxTimes() {
//        return this.categoria.getMaxTimes();
//    }
 
    public void maxTimes(int maxTimes) {
        this.categoria.setMaxJogadores(maxTimes);
    }
    
//    public void setSexo(String sexo) {
//    	    if(sexo == "Masc") this.categoria.setSexo(Masculino);
//    	    else this.categoria.setSexo(Feminino);
//    }
    
    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
     
    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	public static Enumeration<EnumSexo> getFeminino() {
		return Feminino;
	}
	public static Enumeration<EnumSexo> getMasculino() {
		return Masculino;
	}
	public static Campeonato getCamp() {
		return camp;
	}
	public static void setCamp(Campeonato camp) {
		CategoriaMB.camp = camp;
	}
	
}
	