class MovimientoColumnaPalo extends MovimientoOrigenDestino {

    protected MovimientoColumnaPalo(Tapete tapete) {
        super("Mover de columna a palo", tapete);
    }

    @Override
    public void ejecutar() {
        origen = tapete.getColumna(this.recoger("De qué columna", Tapete.NUM_COLUMNAS));
        destino = tapete.getPalo(this.recoger("A qué palo", Baraja.NUM_PALOS));
        super.ejecutar();
    }
    
 }
