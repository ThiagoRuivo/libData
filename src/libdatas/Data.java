
package libdatas;

public class Data {
  /*
    Campos
  */
  private int dia;
  private int mes;
  private int ano;

  /*
    Construtores
  */
  public Data() {
  }
  public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }
  
  /*
    Get's e Set's 
  */
  public int getDia() {
    return dia;
  }
  public void setDia(int dia) {
    this.dia = dia;
  }
  public int getMes() {
    return mes;
  }
  public void setMes(int mes) {
    this.mes = mes;
  }
  public int getAno() {
    return ano;
  }
  public void setAno(int ano) {
    this.ano = ano;
  }

  /*
    Demais métodos
  */
  public String montarRegex (int mes, int ano) {
    String regex = "";
    switch (mes) {
      case 1:
        regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 2:
        if (ano % 1 == 0) {
          regex = "^([012][0-9])/(0[1-9]|1[012])/[0-9]{1,9}$";
        } else {
          regex = "^([01][0-9]|2[0-8])/(0[1-9]|1[012])/[0-9]{1,9}$";
        }
        break;
      case 3:
        regex = "^([012][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 4:
        regex = "^([012][0-9]|30)/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 5:
        regex = "^([012][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 6:
        regex = "^([012][0-9]|30)/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 7:
        regex = "^([012][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 8:
        regex = "^([012][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 9:
        regex = "^([012][0-9]|30)/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 10:
        regex = "^([012][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 11:
        regex = "^([012][0-9]|30)/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      case 12:
        regex = "^([012][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{1,9}$";
        break;
      default:
        throw new AssertionError();
    }
    return regex;
  }
  public Data stringToData (String data) {
    Data novaData = new Data();
    String[] auxiliar = data.split("/");
    novaData.setDia(Integer.parseInt(auxiliar[0]));
    novaData.setMes(Integer.parseInt(auxiliar[1]));
    novaData.setAno(Integer.parseInt(auxiliar[2]));
    return novaData;
  }
  public String dataParseString (Data data) {
    String novaData = "";
    novaData = String.format("%02d/%02d/%d", data.getDia(), data.getMes(), data.getAno());
    return novaData;
  }
  public void imprimirData () {
    System.out.println(String.format("%02d%02d%d", this.dia, this.mes, this.ano));
  }
  public boolean validarData (String data) {
    boolean valido = false;
    try {
      String regexPossuiBarras = "[0-9]{2}/[0-9]{2}/[0-9]{1,9}";
      if (data.matches(regexPossuiBarras)) {
        int ano = Integer.parseInt(data.split("/")[2]);
        int mes = Integer.parseInt(data.split("/")[1]);
        String regexData = montarRegex(mes, ano);
        if (data.matches(regexData)) {
          valido = true;
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return valido;
  }
  public boolean validarData (Data data) {
    boolean valido = false;
    UtilData ud = new UtilData();
    int maxDias = ud.escolherMes(data.getMes(), data.getAno());
    if ((data.getDia() >= 0 && data.getDia() <= maxDias) && 
        (data.getMes()>= 0 && data.getMes() <= 12) && 
        (data.getAno()>= 0)) {
      valido = true;
    }
    return valido;
  }
}
