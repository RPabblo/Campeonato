import java.util.List;
import java.util.Random;

public class Campeonato {

    public List<Clube> clubes;

    public Campeonato(List<Clube> clubes) {
        this.clubes = clubes;
    }


    public void jogarCampeonato() {
        System.out.println("\n                   PLACARES\n----------------------------------------------\n");
        for (Clube m : this.clubes) {
            for (Clube n : this.clubes) {
                if(m != n) { // Joga somente se forem times diferentes.
                    jogarPartida(m, n);
                }
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------\n");
        
    }


    // Seleciona 2 números entre 0 e 6 (inclusivo) pseudo-aleatórios como números de gols.
    private void jogarPartida(Clube m, Clube n) {
        Random rand = new Random();

        int r1 = rand.nextInt(6);
        int r2 = rand.nextInt(6);

        if(r1 > r2) {
            m.ganhar(r1, r2);
            n.perder(r2, r1);
        }
        else if (r2 > r1) {
            m.perder(r1, r2);
            n.ganhar(r2, r1);
        }
        else {
            m.empatar(r1, r2);
            n.empatar(r2, r1);
        }
        System.out.println(m.nome + " " + r1 + " X " + r2 + " " + n.nome);
    }


    public String getCampeao() {
        return this.clubes.get(0).getNome(); // Primeiro time da lista é o campeão.
    }


    // Retorna uma String com  o placar utilizando StringBuilder.
    public String getClassificacao() {
        this.clubes = selectionSort();

        StringBuilder minhaString = new StringBuilder("Time\t\t\tGF\tGS\tSG\tPTS\n");

        for(Clube clube : this.clubes) {
            minhaString.append(clube.getNome() + "\t\t" + clube.getGolsFeitos() + "\t" +
            clube.getGolsSofridos() + "\t" +
            clube.getSaldoGols() + "\t" +
            clube.getPontos() + "\n");        
        }

        return minhaString.toString();
    }


// =========================================================================================


    private List<Clube> selectionSort() {
        Clube[] array = new Clube[this.clubes.size()];
        clubes.toArray(array);
   
        Clube temp;
        int menor;

        // Ordena com base nos pontos.
        for(int i = 0; i < this.clubes.size() - 1; i++) {
            menor = i;
            for(int j = i + 1; j < this.clubes.size(); j++) {
                if(array[j].getPontos() < array[menor].getPontos()) {
                    menor = j;
                }
            }
            temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
        }


        //Caso times aprsentem mesma pontuação, o desempate será de acordo com o saldo de gols.
        for(int i = 0; i < this.clubes.size() - 1; i++) {
            menor = i;
            for(int j = i + 1; j < this.clubes.size(); j++) {
                if(array[j].getPontos() == array[menor].getPontos() && array[j].getSaldoGols() < array[menor].getSaldoGols()) {
                    menor = j;
                }
            }
            temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
        }

        // Após o selection sort, o array está em ordem crescente de pontuação. 
        // Limpa a lista original e insere nela a classificação. Insere a partid do fim do array devido ao fato acima.
        this.clubes.clear();
        for(int i = array.length - 1; i >= 0; i--) {
            clubes.add(array[i]);
        }

        return this.clubes;
    }
}