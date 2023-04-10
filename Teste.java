import java.util.List;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        List<Clube> clubes = new ArrayList<Clube>();

        Clube c1 = new Clube("Barcelona");
        Clube c2 = new Clube("Real Madrid");
        Clube c3 = new Clube("Manchester City");
        Clube c4 = new Clube("Juventus");

        clubes.add(c1);
        clubes.add(c2);
        clubes.add(c3);
        clubes.add(c4);

        Campeonato campeonato = new Campeonato(clubes);
        
        campeonato.jogarCampeonato();
        System.out.println(campeonato.getClassificacao()); 
        System.out.println(campeonato.getCampeao() + " é o campeão!\n");
    }
}