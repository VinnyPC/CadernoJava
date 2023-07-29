package Stream;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private String telefone;
	private Integer idade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	

	public Funcionario(Integer id, String nome, String telefone, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "StreamObjeto1 [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", idade=" + idade + "]";
	}
	
	
	
	

}
