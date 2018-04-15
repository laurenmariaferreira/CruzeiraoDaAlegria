package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Inscricao;

public class InscricaoService {

	private List <Inscricao> inscricoes = new ArrayList<Inscricao>();
	
	public InscricaoService()
	{

	}
	
	public void salvar(Inscricao inscricao)
	{
		inscricoes.add(inscricao);
	}

	public void remove(Inscricao inscricao)
	{
		inscricoes.remove(inscricao);
	}

	public List <Inscricao> getInscricoes()
	{
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> list) {
		this.inscricoes = list;
	}
	
	
}
