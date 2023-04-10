public class Clube {
    public String nome;
    public int pontos;
    public int saldoGols;

    private int golsFeitos;
    private int golsSofridos;

    public Clube(String nome) {
        this.nome = nome;
        this. pontos = 0;
        golsFeitos = 0;
        this.golsSofridos = 0;
        this.saldoGols = 0;    }

    public void ganhar(int golsFeitos, int golsSofridos) {
        this.pontos += 3;
        this.golsFeitos += golsFeitos;
        this.golsSofridos += golsSofridos;
        atualizarSaldo();
    }

    public void empatar(int golsFeitos, int golsSofridos) {
        this.pontos += 1;
        this.golsFeitos += golsFeitos;
        this.golsSofridos += golsSofridos;
        atualizarSaldo();
    }

    public void perder(int golsFeitos, int golsSofridos) {
        this.golsFeitos += golsFeitos;
        this.golsSofridos += golsSofridos;
        atualizarSaldo();
    }

    private void atualizarSaldo() {
        this.saldoGols = golsFeitos - golsSofridos;
    }

    public String toString() {
        return "Nome: " + this.nome
                + "; Saldo: " + this.saldoGols
                + "; Gols  feitos: " + this.golsFeitos
                + "; Gols  sofridos: " + this.golsSofridos
                + "; Pontos: " + this.pontos
                + "; Saldo: " + this.saldoGols;
    }

    public String getNome() {
        return this.nome;
    }
    public int getPontos() {
        return this.pontos;
    }
    public int getGolsFeitos() {
        return this.golsFeitos;
    }
    public int getGolsSofridos() {
        return this.golsSofridos;
    }
    public int getSaldoGols() {
        return this.saldoGols;
    }
}