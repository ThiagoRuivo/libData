
package libdatas;

public class UtilDataHora {
  /*
    Campos
  */
  private DataHora dataHora;

  /*
    Construtores
  */
  public UtilDataHora () { 
  }
  public UtilDataHora(DataHora dataHora) {
    this.dataHora = dataHora;
  }
  
  /*
    Get's e Set's
  */
  public DataHora getData() {
    return this.dataHora;
  }
  public void setData(DataHora dataHora) {
    this.dataHora = dataHora;
  }
  
  /*
    Demais métodos
  */
  public long lapsoTempo (DataHora dhInicio, DataHora dhFinal) {
    long quantidade = 0;
    if ((dhInicio.getData().validarData(dhInicio.getData()) && dhInicio.getHora().validarHora(dhInicio.getHora())) &&
        (dhFinal.getData().validarData(dhFinal.getData()) && dhFinal.getHora().validarHora(dhFinal.getHora()))) {
      UtilData ud = new UtilData();
      UtilHora uh = new UtilHora();
      long dias = ud.diaParaSegundo(dhInicio.getData(), dhFinal.getData());
      long horasInicio = uh.horaParaSegundo(dhInicio.getHora());
      long horasFinal = uh.horaParaSegundo(dhFinal.getHora());
      quantidade = dias + (horasFinal - horasInicio);
    }
    return quantidade;
  }
  public String lapsoTempoString (DataHora dhInicio, DataHora dhFinal) {
    String retorno = "";
    int aux = 0;
    double a = 0;
    double b = 0;
    double quantidade = (double) lapsoTempo(dhInicio, dhFinal);
    aux = (int) (quantidade / (86400 * 365));
    if (aux >= 1) {
      if (aux == 1) {
        retorno += String.format("%d ano", aux);
      } else {
        retorno += String.format("%d anos", aux);
      }
      a = 86400;
      b = 365;
      quantidade = quantidade - (a * b * aux);
    }
    aux = (int) (quantidade / (86400 * 30));
    if (aux >= 1) {
      if (aux == 1) {
        retorno += String.format(", %d mes", aux);
      } else {
        retorno += String.format(", %d meses", aux);
      }
      a = 86400;
      b = 30;
      quantidade = quantidade - (a * b * aux);
    }
    aux = (int) (quantidade / 86400);
    if (aux >= 1) {
      if (aux == 1) {
        retorno += String.format(", %d dia", aux);
      } else {
        retorno += String.format(", %d dias", aux);
      }
      a = 86400;
      quantidade = quantidade - (a * aux);
    }
    aux = (int) (quantidade / 3600);
    if (aux >= 1) {
      if (aux == 1) {
        retorno += String.format(", %d hora", aux);
      } else {
        retorno += String.format(", %d horas", aux);
      }
      a = 3600;
      quantidade = quantidade - (a * aux);
    }
    aux = (int) (quantidade / 60);
    if (aux >= 1) {
      if (aux == 1) {
        retorno += String.format(", %d minuto", aux);
      } else {
        retorno += String.format(", %d minutos", aux);
      }
      a = 60;
      quantidade = quantidade - (a * aux);
    }
    aux = (int) (quantidade);
    if (aux >= 1) {
      if (aux == 1) {
        retorno += String.format(", %d segundo", aux);
      } else {
        retorno += String.format(", %d segundos", aux);
      }
    }
    return retorno;
  }
  
}
