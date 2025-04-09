class Klondike {
    
    private Tapete tapete;    
    
    private Menu menu;
    
    private Klondike() {
        tapete = new Tapete();
        menu = new Menu();
        menu.a�adir(new MovimientoBarajaDescarte(tapete));
        menu.a�adir(new MovimientoDescartePalo(tapete));
        menu.a�adir(new MovimientoDescarteColumna(tapete));
        menu.a�adir(new MovimientoPaloColumna(tapete));
        menu.a�adir(new MovimientoColumnaPalo(tapete));
        menu.a�adir(new MovimientoColumnaColumna(tapete));
        menu.a�adir(new VolteoEnColumna(tapete));
        menu.a�adir(new MovimeintoDescarteBaraja(tapete));
        menu.cerrar();
    }
    
    private void jugar() {
        do {
            tapete.mostrar();
            menu.mostrar();
            menu.getOpcion().ejecutar();
        } while (!menu.terminado());
    }
    
    public static void main(String[] args) {
        new Klondike().jugar();
    }
}