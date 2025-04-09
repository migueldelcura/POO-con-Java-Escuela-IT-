class VolteoEnColumna extends OpcionKlondike {

    public VolteoEnColumna(Tapete tapete){
        super("Voltear en columna", tapete);
    }
    
    @Override
    public void ejecutar(){
        Columna columna = tapete.getColumna(this.recoger("Qué columna", Tapete.NUM_COLUMNAS));
        if (columna.vacia()) {
            this.error("No hay cartas en la columna");
        } else if (columna.cima().bocaArriba()){
            this.error("La carta está boca arriba");
        } else {
            columna.cima().voltear();
        }
    }
}
