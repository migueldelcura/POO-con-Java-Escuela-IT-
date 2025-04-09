class MovimientoPaloColumna extends MovimientoOrigenDestino {

    protected MovimientoPaloColumna(Tapete tapete) {
        super("Mover de palo a columna", tapete);
    }

    @Override
    public void ejecutar() {
        origen = tapete.getPalo(this.recoger("De qué palo", Baraja.NUM_PALOS));
        destino = tapete.getColumna(this.recoger("A qué columna", Tapete.NUM_COLUMNAS));
        super.ejecutar();
    }
        
}
