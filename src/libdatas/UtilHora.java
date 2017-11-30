
package libdatas;

import java.util.Calendar;

public class UtilHora {
  /*
    Campos
  */
  

  /*
    Construtores
  */
  public UtilHora () {  
  }

  /*
    Get's e Set's
  */
  
  /*
    Demais métodos
  */
  public String getAgora() {
    Calendar c = Calendar.getInstance();
    return String.format("%02d:%02d:%02d", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
  }
  public boolean verificarHoras (Hora horaInicio, Hora horaFinal) {
    boolean valido = false;
    if (horaFinal.getHoras() == horaInicio.getHoras()) {
      if (horaFinal.getMinutos() == horaInicio.getMinutos()) {
        if (horaFinal.getSegundos() > horaInicio.getSegundos()) {
          valido = true;
        }
      } else {
        if (horaFinal.getMinutos() > horaInicio.getMinutos()) {
          valido = true;
        }
      }
    } else {
      if (horaFinal.getHoras() > horaInicio.getHoras()) {
        valido = true;
      }
    }
    return valido;
  }
  public int diferencaHoras (Hora horaInicio, Hora horaFinal) {
    int retorno = 0;
    if (verificarHoras(horaInicio, horaFinal)) {
      int difHoras = horaFinal.getHoras() - horaInicio.getHoras();
      int difMinutos = horaFinal.getMinutos() - horaInicio.getMinutos();
      int difSegundos = horaFinal.getSegundos() - horaInicio.getSegundos();
      retorno += (difHoras * 3600);
      retorno += (difMinutos * 60);
      retorno += difSegundos;
    }
    return retorno;
  }
  public String lapseEntreHoras (Hora horaInicio, Hora horaFinal) {
    int numSegundos = diferencaHoras(horaInicio, horaFinal);
    return String.format("Entre %02d:%02d:%02d e %02d:%02d:%02d existem %d segundos", 
            horaInicio.getHoras(),
            horaInicio.getMinutos(),
            horaInicio.getSegundos(),
            horaFinal.getHoras(),
            horaFinal.getMinutos(),
            horaFinal.getSegundos(),
            numSegundos);
  }
  public long horaParaSegundo (Hora hora) {
    long quantidade = 0;
    quantidade += hora.getHoras() * 3600;
    quantidade += hora.getMinutos() * 60;
    quantidade += hora.getSegundos();
    return quantidade;
  }
  public long horaParaSegundo (String hora) {
    long quantidade = 0;
    Hora novaHora = new Hora();
    novaHora = novaHora.stringToHora(hora);
    quantidade += novaHora.getHoras() * 3600;
    quantidade += novaHora.getMinutos() * 60;
    quantidade += novaHora.getSegundos();
    return quantidade;
  }
}
