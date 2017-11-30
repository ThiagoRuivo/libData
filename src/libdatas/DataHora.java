
package libdatas;

public class DataHora {
  /*
    Campos
  */
  private Data data;
  private Hora hora;

  /*
    Construtores
  */
  public DataHora() {
  }
  public DataHora(Data data, Hora hora) {
    this.data = data;
    this.hora = hora;
  }
  public DataHora(int dia, int mes, int ano, int hora, int minuto, int segundo) {
    Data novaData = new Data(dia, mes, ano);
    Hora novaHora = new Hora(hora, minuto, segundo);
    this.data = novaData;
    this.hora = novaHora;
  }

  /*
    Get's e Set's 
  */
  public Data getData() {
    return data;
  }
  public void setData(Data data) {
    this.data = data;
  }
  public Hora getHora() {
    return hora;
  }
  public void setHora(Hora hora) {
    this.hora = hora;
  }
  
  /*
    Demais métodos
  */
  public DataHora stringToDataHora (String dataHora) {
    DataHora novaDataHora = new DataHora();
    String[] aux = dataHora.split(" ");
    String[] auxData = aux[0].split("/");
    String[] auxHora = aux[1].split(":");
    novaDataHora.getData().setDia(Integer.parseInt(auxData[0]));
    novaDataHora.getData().setMes(Integer.parseInt(auxData[1]));
    novaDataHora.getData().setAno(Integer.parseInt(auxData[2]));
    novaDataHora.getHora().setHoras(Integer.parseInt(auxHora[0]));
    novaDataHora.getHora().setMinutos(Integer.parseInt(auxHora[1]));
    novaDataHora.getHora().setSegundos(Integer.parseInt(auxHora[2]));
    return novaDataHora;
  }
  public String dataHoraParseString (DataHora dataHora) {
    String novaDataHora = "";
    return novaDataHora;
  }
  public void imprimirDataHora () {
    System.out.println(String.format("%02d/%02d/%d %02d:%02d:%02d", 
            this.data.getDia(), 
            this.data.getMes(), 
            this.data.getAno(), 
            this.hora.getHoras(), 
            this.hora.getMinutos(), 
            this.hora.getSegundos()));
  }
  public Data converterParaData (DataHora dataHora) {
    Data novaData = new Data();
    novaData.setAno(dataHora.getData().getAno());
    novaData.setMes(dataHora.getData().getMes());
    novaData.setDia(dataHora.getData().getDia());
    return novaData;
  }
  public Data converterParaData (String dataHora) {
    Data novaData = new Data();
    
    return novaData;
  }
  public Hora converterParaHora (DataHora dataHora) {
    Hora novaHora = new Hora();
    novaHora.setHoras(dataHora.getHora().getHoras());
    novaHora.setMinutos(dataHora.getHora().getMinutos());
    novaHora.setSegundos(dataHora.getHora().getSegundos());
    return novaHora;
  }
  public Hora converterParaHora (String dataHora) {
    Hora novaHora = new Hora();
    return novaHora;
  }
}
