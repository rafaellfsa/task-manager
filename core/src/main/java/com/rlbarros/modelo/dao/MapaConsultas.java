package com.rlbarros.modelo.dao;

import java.io.BufferedInputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 * Classe que lê um arquivo de consulta no formato yaml e monta um mapa a partir dele
 * 
 * @author Rafael.Barros
 *
 */
public final class MapaConsultas {

	private Map<String, String> consultas = null;

	/**
	 * Cria o mapa a partir do arquivo passado
	 * @param fileName
	 */
	@SuppressWarnings("unchecked")
	public MapaConsultas(String fileName) {
		BufferedInputStream inpSt = new BufferedInputStream(getClass().getResourceAsStream("/" + fileName));
		this.consultas = (Map<String, String>) new Yaml().load(inpSt);
	}

	/**
	 * Retorna a consulta com o nome passado
	 * 
	 * @param nome
	 * @return
	 */
	public String getConsulta(final String nome) {
		return consultas.get(nome);
	}
}
