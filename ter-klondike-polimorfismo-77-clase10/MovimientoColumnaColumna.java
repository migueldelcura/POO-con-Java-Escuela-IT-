class MovimientoColumnaColumna extends MovimientoOrigenDestino {

    protected MovimientoColumnaColumna(Tapete tapete) {
        super("Mover de columna a columna", tapete);
    }

    @Override
    public void ejecutar() {
        origen = tapete.getColumna(this.recoger("De qué columna", Tapete.NUM_COLUMNAS));
        destino = tapete.getColumna(this.recoger("A qué columna", Tapete.NUM_COLUMNAS));
        super.ejecutar();
    }
    
}
