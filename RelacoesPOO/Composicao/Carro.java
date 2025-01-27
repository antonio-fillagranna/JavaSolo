class Carro {
    private String modelo;
    private Motor motor;

    public Carro(String modelo, String tipoMotor) {
        this.modelo = modelo;
        this.motor = new Motor(tipoMotor);
    }

    public void mostrarDetalhes() {
        System.out.println("Carro: " + modelo + " com motor " + motor.getTipo());
    }
}