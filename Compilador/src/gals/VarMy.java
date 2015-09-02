/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gals;

/**
 *
 * @author 3193683
 */
public class VarMy {

    private int id, tipoNumerico;
    private String tipo = "Null";
    private String nome = "Null";
    private Boolean declarada = false;
    private Boolean inicializada = false;
    private Boolean utilizada = false;
    private int compativel = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getDeclarada() {
        return declarada;
    }

    public void setDeclarada(Boolean declarada) {
        this.declarada = declarada;
    }

    public Boolean getInicializada() {
        return inicializada;
    }

    public void setInicializada(Boolean inicializada) {
        this.inicializada = inicializada;
    }
    
    public Boolean getUtilizada() {
        return utilizada;
    }

    public void setUtilizada(Boolean utilizada) {
        this.utilizada = utilizada;
    }

    public int getCompativel() {
        return compativel;
    }

    public void setCompativel(int compativel) {
        this.compativel = compativel;
    }
    
    public int getTipoNumerico() {
        return tipoNumerico;
    }

    public void setTipoNumerico(int tipoNumerico) {
        this.tipoNumerico = tipoNumerico;
    }
    
    
}
