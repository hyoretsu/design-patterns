public abstract class Apartamento {
    protected Integer areaApartamento;
    protected Integer numeroQuartos;

    public Apartamento(Integer numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public void setAreaApartamento(Integer area) {
        this.areaApartamento = area;
    };

    public abstract void upgrade();
}
