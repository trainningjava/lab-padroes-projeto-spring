package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Os atributos desse modelo foram gerados automaticamente pelo site
 * jsonschema2pojo.org. Para isso, usamos o JSON de retorno da API do ViaCEP.
 * 
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 * 
 * @author falvojr
 */
@Entity
public class Endereco {

	@Id
	@Schema(
		description = "Código de Endereçamento Postal (somente números)", 
		example = "01001000"
	)
    private String cep;

    @Schema(
		description = "Nome do arruamento (rua, avenida, praça, etc.)", 
		example = "Praça da Sé"
	)
    private String logradouro;

    @Schema(
		description = "Dados adicionais para localização (apto, bloco, fundos, etc.)", 
		example = "lado ímpar"
	)
    private String complemento;

    @Schema(
		description = "Nome do bairro correspondente", 
		example = "Sé"
	)
    private String bairro;

    @Schema(
		description = "Nome da cidade ou município", 
		example = "São Paulo"
	)
    private String localidade;

    @Schema(
		description = "Sigla do Estado (Unidade da Federação)", 
		example = "SP"
	)
    private String uf;

    @Schema(
		description = "Código identificador do município no IBGE", 
		example = "3550308"
	)
    private String ibge;

    @Schema(
		description = "Guia de Informação e Apuração do ICMS (Retornado apenas para SP)", 
		example = "1004", 
		nullable = true
	)
    private String gia;

    @Schema(
		description = "Código DDD de telefone da região", 
		example = "11"
	)
    private String ddd;

    @Schema(
		description = "Código identificador do município no Sistema SIAFI do Governo Federal", 
		example = "7107"
	)
    private String siafi;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

}
