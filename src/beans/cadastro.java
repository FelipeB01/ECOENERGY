
package beans;

/**
 *
 * @author fabio.nmoura
 */
public class cadastro {
 
    private int id;
    private String nome;
    private String Data;
    private int qtde;
   private String login;
     private String senha;
   private int capacidade; 
    private String funcionarios;
    private String senhafun;
    private int CEP;
    private String cliente;
    
     public String getcliente() {
        return cliente;
    }

    // Setter
    public void setcliente(String cliente) {
        this.cliente = cliente;
    }

      public int getcapacidade() {
        return capacidade;
    }
      public int getId() {
        return id;
    }
       public String getnome() {
        return nome;
    }
        public int getqtde() {
        return qtde;
    }
         public String getlogin() {
        return login;
    }
          public String getsenha() {
        return senha;
    }
          public void setId(int id) {
        this.id = id;
    }
 public void setnome(String nome) {
        this.nome = nome;
    }
 public void setcapacidade(int capacidade) {
        this.capacidade = capacidade;
 }
 public void setqtde(int qtde) {
        this.qtde = qtde;
    }
 public void setsenha(String senha) {
        this.senha = senha;
    }
 public void setlogin(String login) {
        this.login=login;
}
     public String getData() {
        return Data;
    }
          public void setData(String Data) {
        this.Data=Data;
} 
          public String getFuncionarios() {
        return funcionarios;
    }
  public String getSenhafun() {
        return senhafun;
    }

  
    public void setSenhafun(String senhafun) {
        this.senhafun = senhafun;
    }
    public void setFuncionarios(String funcionarios) {
        this.funcionarios = funcionarios;
    }
     public int getCEP() {
        return CEP;
    }

    // Setter
    public void setCEP(int CEP) {
        this.CEP = CEP;
    }
}

