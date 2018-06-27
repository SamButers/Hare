package hare.estudio.com.gaso_;

public class Posto {
    int Id;
    String nome;
    String gasolina;
    String endereço;

    public Posto (){

    }

    public Posto (int _Id, String _nome, String _gasolina,String _endereço ){
        this.Id= _Id;
        this.nome= _nome;
        this.gasolina= _gasolina;
        this.endereço= _endereço;

    }

    public Posto (String _nome, String _gasolina,String _endereço){
        this.nome= _nome;
        this.gasolina= _gasolina;
        this.endereço= _endereço;

    }
    //==============================================================================

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGasolina() {
        return gasolina;
    }

    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}
