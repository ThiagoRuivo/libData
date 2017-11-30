
package libdatas;

import java.util.Calendar;

public class UtilData {
  /*
    Campos
  */
  private final int JAN = 31;
  private final int FEV = 28;
  private final int FEV6 = 29;
  private final int MAR = 31;
  private final int ABR = 30;
  private final int MAI = 31;
  private final int JUN = 30;
  private final int JUL = 31;
  private final int AGO = 31;
  private final int SET = 30;
  private final int OUT = 31;
  private final int NOV = 30;
  private final int DEZ = 31;

  /*
    Construtores
  */
  public UtilData() {
  }
  
  /*
    Get's & Set's
  */
  public int getJAN() {
    return JAN;
  }
  public int getFEV() {
    return FEV;
  }
  public int getFEV6() {
    return FEV6;
  }
  public int getMAR() {
    return MAR;
  }
  public int getABR() {
    return ABR;
  }
  public int getMAI() {
    return MAI;
  }
  public int getJUN() {
    return JUN;
  }
  public int getJUL() {
    return JUL;
  }
  public int getAGO() {
    return AGO;
  }
  public int getSET() {
    return SET;
  }
  public int getOUT() {
    return OUT;
  }
  public int getNOV() {
    return NOV;
  }
  public int getDEZ() {
    return DEZ;
  }
  
  /*
    Demais métodos
  */
  public String getHoje () {
    Calendar c = Calendar.getInstance();
    return String.format("%02d/%02d/%d", c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
  }
  public String getHojeMySql () {
    Calendar c = Calendar.getInstance();
    return String.format("%d-%02d-%02d", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
  }
  public String getDateTime () {
    Calendar c = Calendar.getInstance();
    return String.format("%02d/%02d/%d %02d:%02d:%02d", 
                          c.get(Calendar.DAY_OF_MONTH), 
                          c.get(Calendar.MONTH) + 1, 
                          c.get(Calendar.YEAR), 
                          c.get(Calendar.HOUR_OF_DAY), 
                          c.get(Calendar.MINUTE), 
                          c.get(Calendar.SECOND));
  }
  public String getDateTimeMySql () {
    Calendar c = Calendar.getInstance();
    return String.format("%d-%02d-%02d %02d:%02d:%02d", 
                          c.get(Calendar.YEAR), 
                          c.get(Calendar.MONTH) + 1, 
                          c.get(Calendar.DAY_OF_MONTH), 
                          c.get(Calendar.HOUR_OF_DAY), 
                          c.get(Calendar.MINUTE), 
                          c.get(Calendar.SECOND));
  }
  public boolean verificarDatas (Data dataInicio, Data dataFinal) {
    boolean valido = false;
    if (dataFinal.getAno() == dataInicio.getAno()) {
      if (dataFinal.getMes() == dataInicio.getMes()) {
        if (dataFinal.getDia() > dataInicio.getDia()) {
          valido = true;
        }
      } else {
        if (dataFinal.getMes() > dataInicio.getMes()) {
          valido = true;
        }
      }
    } else {
      if (dataFinal.getAno() > dataInicio.getAno()) {
        valido = true;
      }
    }
    return valido;
  }
  public int escolherMes (int mes, int ano) {
    int dias = 0;
    switch (mes) {
      case 1:
        dias = this.JAN;
        break;
      case 2:
        if (ano % 4 == 0) {
          dias = this.FEV6;
        } else {
          dias = this.FEV;
        }
        break;
      case 3:
        dias = this.MAR;
        break;
      case 4:
        dias = this.ABR;
        break;
      case 5:
        dias = this.MAI;
        break;
      case 6:
        dias = this.JUN;
        break;
      case 7:
        dias = this.JUL;
        break;
      case 8:
        dias = this.AGO;
        break;
      case 9:
        dias = this.SET;
        break;
      case 10:
        dias = this.OUT;
        break;
      case 11:
        dias = this.NOV;
        break;
      case 12:
        dias = this.DEZ;
        break;
      default:
        System.out.println("Não existe um mês com esse número");;
    }
    return dias;
  }
  public int diferencaDatas (Data dataInicio, Data dataFinal) {
    int retorno = 0;
    if (verificarDatas(dataInicio, dataFinal)) {
      int difAnos = dataFinal.getAno() - dataInicio.getAno();
      int difMeses = dataFinal.getMes() - dataInicio.getMes();
      int difDias = dataFinal.getDia() - dataInicio.getDia();
      retorno += difAnos * 365;
      retorno += difAnos / 4;
      retorno += difDias;
      int numDias = 0;
      if (difMeses > 0) {
        for (int i = dataInicio.getMes() + 1; i <= dataFinal.getMes(); i++) {
          numDias += escolherMes(i, dataFinal.getAno());
        }
      } else {
        for (int i = dataFinal.getMes() + 1; i <= dataInicio.getMes(); i++) {
          numDias -= escolherMes(i, dataFinal.getAno());
        }
      }
      retorno += numDias;
    }
    return retorno;
  }
  public String lapseEntreDatas (Data dataInicio, Data dataFinal) {
    int numDias = diferencaDatas(dataInicio, dataFinal);
    String retorno = String.format("De: %02d/%02d/%d a %02d/%02d/%d existem %d dias", 
            dataInicio.getDia(), 
            dataInicio.getMes(), 
            dataInicio.getAno(), 
            dataFinal.getDia(),
            dataFinal.getMes(),
            dataFinal.getAno(),
            numDias);
    return retorno;
  }
  public long diaParaSegundo (Data dataInicio, Data dataFinal) {
    return (long) diferencaDatas(dataInicio, dataFinal) * 86400;
  }
  public long diaParaSegundo (String dataInicio, String dataFinal) {
    Data novaDataInicio = new Data();
    Data novaDataFinal = new Data();
    novaDataInicio = novaDataInicio.stringToData(dataInicio);
    novaDataFinal = novaDataFinal.stringToData(dataFinal);
    return (long) diferencaDatas(novaDataInicio, novaDataFinal) * 86400;
  }
}
