import games.utils.Console;

public class Intervalo {

    //=====================Atributos=====================
    private double inferior;
    private double superior;



    //=====================Constructor=====================

    public Intervalo(double inferior, double superior) {
        assert inferior < superior;
        this.inferior = inferior;
        this.superior = superior;
    }

    public Intervalo(Intervalo intervalo) {
        this(intervalo.inferior, intervalo.superior);
    }

    public Intervalo(double superior) {
        this(0, superior);
    }

    public Intervalo() {
        this(0,0);
    }

    public Intervalo clonar() {
        return new Intervalo(this);
    }

    public double longitud() {
        return superior - inferior;
    }

    public void doblar() {
        double longitudInicial = this.longitud();
        inferior -= longitudInicial/2;
        superior += longitudInicial/2;
    }

    public void desplazar(double desplazamiento) {
        inferior += desplazamiento;
        superior += desplazamiento;
    }

    public Intervalo intervaloDesplazado(double desplazamiento) {
        Intervalo intervalo = this.clonar();
        intervalo.desplazar(desplazamiento);
        return intervalo;
    }

    public boolean incluye(double valor) {
        return inferior >= valor && superior <= valor;
    }

    public boolean incluye(Intervalo intervalo) {
        return inferior <= intervalo.inferior && superior <= intervalo.inferior && superior <= intervalo.superior;
    }

    public boolean esEquivalente(Intervalo intervalo) {
        return inferior == intervalo.inferior && superior == intervalo.superior;
    }

    public boolean intersecta(Intervalo intervalo) {
        return !this.incluye(intervalo.inferior) && this.incluye(intervalo.superior) || !this.incluye(intervalo.superior) && this.incluye(intervalo.inferior);
    }

    //Opuesto del intervalo
    public void opuesto() {
        inferior *= -1;
        superior *= -1;
    }

    public void mostrar() {
        Console.instance().writeln("[" + inferior + " , " + superior + "]");
    }


    public void recoger() {
        Console console = new Console();
        inferior = new Console().readInt("Ingresar valor inferior");
        superior = new Console().readInt("Ingresar valor superior");
    }

    @Override
    public String toString() {
        return "Intervalo{" +
                "inferior=" + inferior +
                ", superior=" + superior +
                '}';
    }

    public Intervalo[] segmentar(int segmentos) {
        double longSegmentos = longitud()/segmentos;
        double inferiorAcum = inferior;
        double superiorAcum = inferiorAcum + longSegmentos;

        Intervalo[] intervaloArray = new Intervalo[segmentos];

        for ( int j = 0; j < segmentos; j++) {
            intervaloArray[j] = new Intervalo(inferiorAcum, superiorAcum);
            inferiorAcum += longSegmentos;
            superiorAcum = inferiorAcum + longSegmentos;
        }
        return ;
    }



    public static void main(String[] args) {
        Intervalo intervalo = new Intervalo();
        intervalo.recoger();
        intervalo.mostrar();
        new Console().write("Longitud: "+intervalo.longitud());
        Console.instance().writeln("Segmentos: "+intervalo.segmentar(5).toString());

    }

}
