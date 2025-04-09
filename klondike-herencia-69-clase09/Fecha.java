import java.util.StringTokenizer;

class Fecha {
	
	private int dia;
	
	private int mes;
	
	private int a�o;
	
	private static final int[] DIAS_MESES = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	private static final char[] INICIALES_DIAS = new char[] {'s','d','l','m','x','j','v'};
	
	public Fecha(){
		this(1,1,1);
	}
	
	public Fecha(int dia, int mes, int a�o){
		this.set(dia, mes, a�o);
	}
	
	public Fecha(Fecha fecha){
		this(fecha.dia, fecha.mes, fecha.a�o);
	}
		
	// 12/5/2008
	public Fecha(String fecha){
		StringTokenizer analizador = new StringTokenizer(fecha, "/");
		dia = Integer.parseInt(analizador.nextToken());	
		mes = Integer.parseInt(analizador.nextToken());
		a�o = Integer.parseInt(analizador.nextToken());
	}
	
	public Fecha(int timeStamp){
		
	}
	
	private void set(int dia, int mes, int a�o){
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}
	
	public void set(Fecha fecha){
		this.set(fecha.dia, fecha.mes, fecha.a�o);
	}
	
	public int getDia(){
		return dia;
	}

	public int getMes(){
		return mes;
	}
	
	public int getA�o(){
		return a�o;
	}
	
	public Fecha clone(){
		return new Fecha(dia, mes, a�o);
	}
	
	public void mostrar(){
		new GestorIO().out(dia+"/"+mes+"/"+a�o);
		
	}

	public String toStringCAS(){
		return dia+"/"+mes+"/"+a�o;
	}

	public String toStringUSA(){
		return mes+"/"+dia+"th, "+a�o;
	}
	
	public boolean igual(Fecha fecha){
		return dia == fecha.dia &&
				mes == fecha.mes &&
				a�o == fecha.a�o;
	}
	
	public boolean anterior (Fecha fecha){
		return this.diasOrigen() < fecha.diasOrigen();
	}
	
	public boolean posterior (Fecha fecha){
		return !this.igual(fecha) && !this.anterior(fecha);
	}
	
	public int diferencia(Fecha fecha){
		return this.diasOrigen() - fecha.diasOrigen();
	}
	
	private int diasOrigen() {
		int resultado = this.diaA�o();
		resultado += 365*(a�o-1);
		for(int i=1; i<a�o-1; i++){
			if (Fecha.bisiesto(i)){
				resultado++;
			}
		}
		return resultado;
	}
	
	public static boolean bisiesto(int a�o){
		return a�o%4 == 0 && a�o%100!=0 || a�o%400==0;
	}
	
	public static int diasA�o(int a�o){
		int resultado = 365;
		if (Fecha.bisiesto(a�o)){
			resultado++;
		}
		return resultado;
	}
	
	public int diaA�o() {
		int resultado = dia;
		for(int i=0; i<(mes-1); i++){
			resultado += DIAS_MESES[i];
		}
		if (mes>2 && this.checkBisiesto()){
			resultado++;
		}
		return resultado;
	}
	
	public boolean festivo(){
		final char DIA_SEMANA = this.diaSemana();
		return DIA_SEMANA == 's' || DIA_SEMANA == 'd' ;
	}
	
	public char diaSemana(){
		return INICIALES_DIAS[(this.diasOrigen()-1)%7];
	}
	
	public char estacion(){
		return ' ';
	}

	public int numeroSemana(){
		return (this.diasOrigen() - new Fecha(1,1,a�o).diasOrigen())/7+1;
	}

	private void incrementar(){
		dia++;
		if (dia>DIAS_MESES[mes-1]){
			dia = 1;
			mes++;
			if (mes>12){
				mes = 1;
				a�o++;
			}
		}
	}
	
	public void incrementar(int dias){
		for(int i=0; i<dias; i++){
			this.incrementar();
		}
	}
	
	public boolean checkBisiesto(){
		return Fecha.bisiesto(a�o);
	}

}
