package br.ulbra.model;

public class Usuario {
    private int usuario_pk;
    private String nomeusu;
    private String emailusu;
    private String datanascusu;
    private int ativousu;
    private String senhausu;
    
    public int getUsuario_pk(){
        return usuario_pk;
    }
    
    public void setUsuario_pk(int usuario_pk) {
        this.usuario_pk = usuario_pk;
    }

    public String getNomeusu() {
        return nomeusu;
    }

    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }

    public String getDatanascusu() {
        return datanascusu;
    }

    public void setDatanascusu(String datanascusu) {
        this.datanascusu = datanascusu;
    }

    public int getAtivousu() {
        return ativousu;
    }

    public void setAtivousu(int ativousu) {
        this.ativousu = ativousu;
    }

    public String getSenhausu() {
        return senhausu;
    }

    public void setSenhausu(String senhausu) {
        this.senhausu = senhausu;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario_pk=" + usuario_pk + ", nomeusu=" + nomeusu 
                + ", emailusu=" + emailusu + ", datanascusu=" + datanascusu 
                + ", ativousu=" + ativousu + ", senhausu=" + senhausu + '}';
    }
    
    
}
