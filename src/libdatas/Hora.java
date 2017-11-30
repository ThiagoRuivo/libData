
package libdatas;

public class Hora {
  /*
    Campos
  */
  private int segundos;
  private int minutos;
  private int horas;

  /*
    Construtores
  */
  public Hora() {
  }
  public Hora(int horas, int minutos, int segundos) {
    this.segundos = segundos;
    this.minutos = minutos;
    this.horas = horas;
  }

  /*
    Get's e Set's
  */
  public int getSegundos() {
    return segundos;
  }
  public void setSegundos(int segundos) {
    this.segundos = segundos;
  }
  public int getMinutos() {
    return minutos;
  }
  public void setMinutos(int minutos) {
    this.minutos = minutos;
  }
  public int getHoras() {
    return horas;
  }
  public void setHoras(int horas) {
    this.horas = horas;
  }
  /*
    Demais métodos
  */
  public Hora stringToHora (String hora) {
    Hora novaHora = new Hora();
    String[] auxiliar = hora.split(":");
    novaHora.setHoras(Integer.parseInt(auxiliar[0]));
    novaHora.setMinutos(Integer.parseInt(auxiliar[1]));
    novaHora.setSegundos(Integer.parseInt(auxiliar[2]));
    return novaHora;
  }
  public String horaParseString (Hora hora) {
    String novaHora = "";
    novaHora = String.format("%02d:%02d:%02d", hora.getHoras(), hora.getMinutos(), hora.getSegundos());
    return novaHora;
  }
  public void imprimirHora () {
    System.out.println(String.format("%02d:%02d:%02d", this.horas, this.minutos, this.segundos));
  }
  public boolean validarHora (String hora) {
    boolean valido = false;
    String regex = "^([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
    if (hora.matches(regex)) {
      valido = true;
    }
    return valido;
  }
  public boolean validarHora (Hora hora) {
    boolean valido = false;
    if ((hora.getHoras() >= 0 && hora.getHoras() <= 23) && 
        (hora.getMinutos()>= 0 && hora.getMinutos() <= 59) && 
        (hora.getSegundos()>= 0 && hora.getSegundos() <= 59)) {
      valido = true;
    }
    return valido;
  }
}
